/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

public class SynchronizedFloatIntMapSerializationTest
{
    @Test
    public void serializedForm()
    {
        Verify.assertSerializedForm(
                1L,
                "rO0ABXNyAEpvcmcuZWNsaXBzZS5jb2xsZWN0aW9ucy5pbXBsLm1hcC5tdXRhYmxlLnByaW1pdGl2\n"
                        + "ZS5TeW5jaHJvbml6ZWRGbG9hdEludE1hcAAAAAAAAAABAgACTAAEbG9ja3QAEkxqYXZhL2xhbmcv\n"
                        + "T2JqZWN0O0wAA21hcHQAPkxvcmcvZWNsaXBzZS9jb2xsZWN0aW9ucy9hcGkvbWFwL3ByaW1pdGl2\n"
                        + "ZS9NdXRhYmxlRmxvYXRJbnRNYXA7eHBxAH4AA3NyAEJvcmcuZWNsaXBzZS5jb2xsZWN0aW9ucy5p\n"
                        + "bXBsLm1hcC5tdXRhYmxlLnByaW1pdGl2ZS5GbG9hdEludEhhc2hNYXAAAAAAAAAAAQwAAHhwdwQA\n"
                        + "AAAAeA==",
                new SynchronizedFloatIntMap(new FloatIntHashMap()));
    }

    @Test
    public void keySetSerializedForm()
    {
        Verify.assertSerializedForm(
                1L,
                "rO0ABXNyAEdvcmcuZWNsaXBzZS5jb2xsZWN0aW9ucy5pbXBsLnNldC5tdXRhYmxlLnByaW1pdGl2\n"
                        + "ZS5TeW5jaHJvbml6ZWRGbG9hdFNldAAAAAAAAAABAgAAeHIAXW9yZy5lY2xpcHNlLmNvbGxlY3Rp\n"
                        + "b25zLmltcGwuY29sbGVjdGlvbi5tdXRhYmxlLnByaW1pdGl2ZS5BYnN0cmFjdFN5bmNocm9uaXpl\n"
                        + "ZEZsb2F0Q29sbGVjdGlvbgAAAAAAAAABAgACTAAKY29sbGVjdGlvbnQASUxvcmcvZWNsaXBzZS9j\n"
                        + "b2xsZWN0aW9ucy9hcGkvY29sbGVjdGlvbi9wcmltaXRpdmUvTXV0YWJsZUZsb2F0Q29sbGVjdGlv\n"
                        + "bjtMAARsb2NrdAASTGphdmEvbGFuZy9PYmplY3Q7eHBzcgBUb3JnLmVjbGlwc2UuY29sbGVjdGlv\n"
                        + "bnMuaW1wbC5tYXAubXV0YWJsZS5wcmltaXRpdmUuQWJzdHJhY3RNdXRhYmxlRmxvYXRLZXlTZXQk\n"
                        + "U2VyUmVwAAAAAAAAAAEMAAB4cHcEAAAAAHhzcgBKb3JnLmVjbGlwc2UuY29sbGVjdGlvbnMuaW1w\n"
                        + "bC5tYXAubXV0YWJsZS5wcmltaXRpdmUuU3luY2hyb25pemVkRmxvYXRJbnRNYXAAAAAAAAAAAQIA\n"
                        + "AkwABGxvY2txAH4AA0wAA21hcHQAPkxvcmcvZWNsaXBzZS9jb2xsZWN0aW9ucy9hcGkvbWFwL3By\n"
                        + "aW1pdGl2ZS9NdXRhYmxlRmxvYXRJbnRNYXA7eHBxAH4ACXNyAEJvcmcuZWNsaXBzZS5jb2xsZWN0\n"
                        + "aW9ucy5pbXBsLm1hcC5tdXRhYmxlLnByaW1pdGl2ZS5GbG9hdEludEhhc2hNYXAAAAAAAAAAAQwA\n"
                        + "AHhwdwQAAAAAeA==",
                new SynchronizedFloatIntMap(new FloatIntHashMap()).keySet());
    }
}
