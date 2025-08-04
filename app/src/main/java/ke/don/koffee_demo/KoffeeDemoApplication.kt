/*
 * Copyright © 2025 Donald O. Isoe (isoedonald@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ke.don.koffee_demo

import android.app.Application
import ke.don.koffee.domain.Koffee
import ke.don.koffee.model.ToastDuration
import ke.don.koffee.ui.DefaultToast

class KoffeeDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Koffee.init {
            layout { DefaultToast(it) } // or custom
            dismissible(true)
            durationResolver { customDurationResolver(it) }
        }
    }

    private fun customDurationResolver(duration: ToastDuration): Long? = when (duration) {
        ToastDuration.Short -> 5000L
        ToastDuration.Medium -> 7000L
        ToastDuration.Long -> 10000L
        ToastDuration.Indefinite -> null
    }
}
