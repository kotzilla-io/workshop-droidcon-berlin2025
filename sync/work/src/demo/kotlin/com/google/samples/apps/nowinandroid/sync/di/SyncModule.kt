/*
 * Copyright 2022 The Android Open Source Project
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

package com.google.samples.apps.nowinandroid.sync.di

import com.google.samples.apps.nowinandroid.core.data.util.SyncManager
import com.google.samples.apps.nowinandroid.sync.status.StubSyncSubscriber
import com.google.samples.apps.nowinandroid.sync.status.SyncSubscriber
import com.google.samples.apps.nowinandroid.sync.status.WorkManagerSyncManager
import com.google.samples.apps.nowinandroid.sync.workers.SyncWorker
//import dagger.Binds
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
import org.koin.androidx.workmanager.dsl.workerOf
//import org.koin.core.component.KoinComponent
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

//@Module
//@InstallIn(SingletonComponent::class)
//object SyncModuleBridgeHilt : KoinComponent {
//
//    @Provides
//    fun providesSyncManager() : SyncManager = getKoin().get()
//
//    @Provides
//    fun providesSyncSubscriber(): SyncSubscriber = getKoin().get()
//}

//@Module(includes = [SyncModuleBridgeHilt::class])
//@InstallIn(SingletonComponent::class)
//abstract class SyncModule {
//
////    @Binds
////    internal abstract fun bindsSyncStatusMonitor(
////        syncStatusMonitor: WorkManagerSyncManager,
////    ): SyncManager
//
////    @Binds
////    internal abstract fun bindsSyncSubscriber(
////        syncSubscriber: StubSyncSubscriber,
////    ): SyncSubscriber
//}

val syncKoinModule = module {
    singleOf(::WorkManagerSyncManager) bind SyncManager::class
    singleOf(::StubSyncSubscriber) bind SyncSubscriber::class
    workerOf(::SyncWorker)
}
