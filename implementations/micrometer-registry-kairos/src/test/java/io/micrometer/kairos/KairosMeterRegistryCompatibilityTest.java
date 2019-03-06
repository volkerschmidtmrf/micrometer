/**
 * Copyright 2017 Pivotal Software, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.kairos;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.MockClock;
import io.micrometer.core.lang.Nullable;
import io.micrometer.core.tck.MeterRegistryCompatibilityKit;

import java.time.Duration;

/**
 * @author Anton Ilinchik
 */
class KairosMeterRegistryCompatibilityTest extends MeterRegistryCompatibilityKit {
    @Override
    public MeterRegistry registry() {
        return new KairosMeterRegistry(new KairosConfig() {
            @Override
            public boolean enabled() {
                return false;
            }

            @Override
            @Nullable
            public String get(String key) {
                return null;
            }
        }, new MockClock());
    }

    @Override
    public Duration step() {
        return KairosConfig.DEFAULT.step();
    }
}