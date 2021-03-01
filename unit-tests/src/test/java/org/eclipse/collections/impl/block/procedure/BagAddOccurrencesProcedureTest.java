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

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.factory.Bags;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

public class BagAddOccurrencesProcedureTest
{
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void basicCase()
    {
        MutableBag<String> targetCollection = Bags.mutable.empty();
        BagAddOccurrencesProcedure<String> procedure = new BagAddOccurrencesProcedure<>(targetCollection);

        procedure.value("fred", 1);
        procedure.value("fred", 1);
        procedure.value("mary", 3);

        Assert.assertEquals(2, procedure.getResult().occurrencesOf("fred"));
        Assert.assertEquals(3, procedure.getResult().occurrencesOf("mary"));
        Assert.assertEquals(0, procedure.getResult().occurrencesOf("other"));
    }

    @Test
    public void basicCaseUsingFactoryMethod()
    {
        MutableBag<String> targetCollection = Bags.mutable.empty();
        BagAddOccurrencesProcedure<String> procedure = BagAddOccurrencesProcedure.on(targetCollection);

        procedure.value("fred", 1);
        procedure.value("fred", 1);
        procedure.value("mary", 3);

        Assert.assertEquals(2, procedure.getResult().occurrencesOf("fred"));
        Assert.assertEquals(3, procedure.getResult().occurrencesOf("mary"));
        Assert.assertEquals(0, procedure.getResult().occurrencesOf("other"));
    }
}
