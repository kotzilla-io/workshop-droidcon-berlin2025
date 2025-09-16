///*
// * Copyright 2022 The Android Open Source Project
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     https://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.google.samples.apps.nowinandroid.core.data.test
//
//import com.google.samples.apps.nowinandroid.core.data.di.DataModule
//import com.google.samples.apps.nowinandroid.core.data.repository.NewsRepository
//import com.google.samples.apps.nowinandroid.core.data.repository.RecentSearchRepository
//import com.google.samples.apps.nowinandroid.core.data.repository.SearchContentsRepository
//import com.google.samples.apps.nowinandroid.core.data.repository.TopicsRepository
//import com.google.samples.apps.nowinandroid.core.data.repository.UserDataRepository
//import com.google.samples.apps.nowinandroid.core.data.test.repository.FakeNewsRepository
//import com.google.samples.apps.nowinandroid.core.data.test.repository.FakeRecentSearchRepository
//import com.google.samples.apps.nowinandroid.core.data.test.repository.FakeSearchContentsRepository
//import com.google.samples.apps.nowinandroid.core.data.test.repository.FakeTopicsRepository
//import com.google.samples.apps.nowinandroid.core.data.test.repository.FakeUserDataRepository
//import com.google.samples.apps.nowinandroid.core.data.util.NetworkMonitor
//import com.google.samples.apps.nowinandroid.core.data.util.TimeZoneMonitor
//import dagger.Binds
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.components.SingletonComponent
//import dagger.hilt.testing.TestInstallIn
//import org.koin.core.component.KoinComponent
//
//@Module
//@TestInstallIn(
//    components = [SingletonComponent::class],
//    replaces = [DataModule::class],
//)
//object TestDataModule : KoinComponent {
//
//    @Provides
//    fun bindsTopicRepository(): TopicsRepository = getKoin().get()
//
//    @Provides
//    fun bindsNewsResourceRepository(): NewsRepository = getKoin().get()
//
//    @Provides
//    fun bindsUserDataRepository(): UserDataRepository = getKoin().get()
//
//    @Provides
//    fun bindsRecentSearchRepository(): RecentSearchRepository = getKoin().get()
//
//    @Provides
//    fun bindsSearchContentsRepository(): SearchContentsRepository = getKoin().get()
//
////    @Provides
////    fun bindsNetworkMonitor(
////        networkMonitor: AlwaysOnlineNetworkMonitor,
////    ): NetworkMonitor
////
////    @Provides
////    fun binds(impl: DefaultZoneIdTimeZoneMonitor): TimeZoneMonitor
//}
