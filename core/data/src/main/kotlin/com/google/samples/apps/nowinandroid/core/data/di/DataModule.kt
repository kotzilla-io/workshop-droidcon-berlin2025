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

package com.google.samples.apps.nowinandroid.core.data.di

import com.google.samples.apps.nowinandroid.core.data.repository.DefaultRecentSearchRepository
import com.google.samples.apps.nowinandroid.core.data.repository.DefaultSearchContentsRepository
import com.google.samples.apps.nowinandroid.core.data.repository.NewsRepository
import com.google.samples.apps.nowinandroid.core.data.repository.OfflineFirstNewsRepository
import com.google.samples.apps.nowinandroid.core.data.repository.OfflineFirstTopicsRepository
import com.google.samples.apps.nowinandroid.core.data.repository.OfflineFirstUserDataRepository
import com.google.samples.apps.nowinandroid.core.data.repository.RecentSearchRepository
import com.google.samples.apps.nowinandroid.core.data.repository.SearchContentsRepository
import com.google.samples.apps.nowinandroid.core.data.repository.TopicsRepository
import com.google.samples.apps.nowinandroid.core.data.repository.UserDataRepository
import com.google.samples.apps.nowinandroid.core.data.util.ConnectivityManagerNetworkMonitor
import com.google.samples.apps.nowinandroid.core.data.util.NetworkMonitor
import com.google.samples.apps.nowinandroid.core.data.util.TimeZoneBroadcastMonitor
import com.google.samples.apps.nowinandroid.core.data.util.TimeZoneMonitor
import com.google.samples.apps.nowinandroid.core.database.di.daosModule
import com.google.samples.apps.nowinandroid.core.datastore.di.dataStoreModule
import com.google.samples.apps.nowinandroid.core.network.di.coroutineScopesKoinModule
import com.google.samples.apps.nowinandroid.core.network.di.flavoredNetworkModule
import com.google.samples.apps.nowinandroid.core.notifications.notificationsModule
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataKoinModule = module {
    includes(userNewsResourceRepositoryKoinModule, coroutineScopesKoinModule, daosModule, dataStoreModule, flavoredNetworkModule, notificationsModule)
    //should be singleOf
    factoryOf(::ConnectivityManagerNetworkMonitor) bind NetworkMonitor::class
    factoryOf(::TimeZoneBroadcastMonitor) bind TimeZoneMonitor::class
    factoryOf(::DefaultSearchContentsRepository) bind SearchContentsRepository::class
    factoryOf(::DefaultRecentSearchRepository) bind RecentSearchRepository::class
    factoryOf(::OfflineFirstNewsRepository) bind NewsRepository::class
    factoryOf(::OfflineFirstTopicsRepository) bind TopicsRepository::class
    factoryOf(::OfflineFirstUserDataRepository) bind UserDataRepository::class
}
