/*
 * Copyright 2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.amplify.amplify_auth_cognito.types

import com.amazonaws.amplify.amplify_auth_cognito.utils.serializeAuthUpdateAttributeResult
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.result.AuthUpdateAttributeResult

data class FlutterUpdateUserAttributesResult(private val raw: Map<AuthUserAttributeKey, AuthUpdateAttributeResult>) {
    val attributes: Map<AuthUserAttributeKey, AuthUpdateAttributeResult> = raw

    fun toValueMap(): Map<String, Any> {
        return attributes.entries.associate {
            it.key.keyString to serializeAuthUpdateAttributeResult(it.value)
        }
    }
}
