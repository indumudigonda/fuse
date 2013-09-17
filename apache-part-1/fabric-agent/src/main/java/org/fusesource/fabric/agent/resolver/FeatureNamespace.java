/**
 * Copyright (C) FuseSource, Inc.
 * http://fusesource.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.fabric.agent.resolver;

import org.osgi.resource.Namespace;

/**
 */
public final class FeatureNamespace extends Namespace {

    public static final String FEATURE_NAMESPACE = "karaf.feature";

    public static final String	CAPABILITY_VERSION_ATTRIBUTE	= "version";

    /**
     * The attribute value identifying the resource
     * {@link org.osgi.framework.namespace.IdentityNamespace#CAPABILITY_TYPE_ATTRIBUTE type} as an OSGi bundle.
     *
     * @see org.osgi.framework.namespace.IdentityNamespace#CAPABILITY_TYPE_ATTRIBUTE
     */
    public static final String	TYPE_FEATURE = "karaf.feature";

    private FeatureNamespace() {
    }
}
