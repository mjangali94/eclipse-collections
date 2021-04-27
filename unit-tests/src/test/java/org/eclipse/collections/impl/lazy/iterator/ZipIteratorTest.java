/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.lazy.iterator;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.collections.impl.PerformanceLogger;
import org.junit.Test;

public class ZipIteratorTest
{
    private static final ImmutableList<Integer> EMPTY = Lists.immutable.of();

    
@Test(expected = UnsupportedOperationException.class)
    public void testRemove()
    {
        new ZipIterator<>(EMPTY, EMPTY).remove();
    }
}
