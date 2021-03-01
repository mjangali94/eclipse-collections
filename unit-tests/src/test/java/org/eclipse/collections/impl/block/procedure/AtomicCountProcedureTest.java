/*
 * Copyright (c) 2020 The Bank of New York Mellon and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.block.procedure;

import org.eclipse.collections.impl.list.Interval;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtomicCountProcedureTest
{
    private static final int STRING_LENGTH = 5;
    private static final int ZERO = 0;

        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void getCount()
    {
        AtomicCountProcedure<String> atomicCountProcedure = new AtomicCountProcedure<>(each -> STRING_LENGTH < each.length());

        atomicCountProcedure.value("word");
        assertEquals(0,  atomicCountProcedure.getCount());

        atomicCountProcedure.value("america");
        assertEquals(1, atomicCountProcedure.getCount());
    }

    @Test(expected = ArithmeticException.class)
    public void predicateException()
    {
        AtomicCountProcedure<String> atomicCountProcedure = new AtomicCountProcedure<>(each -> STRING_LENGTH < each.length() / ZERO);

        atomicCountProcedure.value("word");
    }

    @Test
    public void parallelProcessing()
    {
        AtomicCountProcedure<Integer> atomicCountProcedure = new AtomicCountProcedure<>(each -> each % 2 == 0);

        Interval.oneTo(50_000)
                .parallelStream()
                .forEach(atomicCountProcedure);

        assertEquals(25_000, atomicCountProcedure.getCount());
    }
}
