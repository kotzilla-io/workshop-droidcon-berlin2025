/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.core.data.model

object Issues {
    private val values = hashMapOf<Issue, Boolean>(
        Issue.STARTUP_TIME to false,
        Issue.DEPENDENCY_PERF to false,
        Issue.CHILD_DEPENDENCY_PERF to true,
        Issue.BLOCKING_RESOLUTION to false,
        Issue.BLOCKING_MAIN to true,
    )

    private val delays = hashMapOf<Issue, Long>(
        Issue.STARTUP_TIME to 6000L,
        Issue.DEPENDENCY_PERF to 250L,
        Issue.CHILD_DEPENDENCY_PERF to 250L,
        Issue.BLOCKING_MAIN to 1000L,
        Issue.BLOCKING_RESOLUTION to 1000L,
    )

    fun hasIssue(i : Issue) : Boolean = values[i] == true
    fun ifHasIssue(i : Issue, block : () -> Unit){
        if (hasIssue(i)){
            block()
        }
    }
    fun blockForIssue(i : Issue){
        if (hasIssue(i)){
            Thread.sleep(delays[i] ?: error("No delay defined for $i - Add it to Issues class"))
        }
    }

    fun blockingThreadIssue(d : Long){
        Thread.sleep(d)
    }

    const val STARTUP_DELAY = 1000L
}

enum class Issue {
    STARTUP_TIME, DEPENDENCY_PERF, CHILD_DEPENDENCY_PERF, BLOCKING_RESOLUTION, BLOCKING_MAIN
}