/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.stack.mutable;

import org.eclipse.collections.api.stack.MutableStack;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.collections.impl.PerformanceLogger;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedStack}.
 */
public class SynchronizedStackTest extends MutableStackTestCase
{
    @Override
    protected <T> MutableStack<T> newStackWith(T... elements)
    {
        return new SynchronizedStack<>(ArrayStack.newStackWith(elements));
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(T... elements)
    {
        return new SynchronizedStack<>(ArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected <T> MutableStack<T> newStackFromTopToBottom(Iterable<T> elements)
    {
        return new SynchronizedStack<>(ArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected <T> MutableStack<T> newStack(Iterable<T> elements)
    {
        return new SynchronizedStack<>(ArrayStack.newStack(elements));
    }

    @org.junit.Rule public PerformanceLogger name = new PerformanceLogger();
@Test
    public void testNullStack()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> SynchronizedStack.of(null));
    }
}
