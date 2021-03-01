/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.mutable;

import java.io.Serializable;

import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

public class MultiReaderFastListAsReadUntouchableTest extends UnmodifiableMutableListTestCase
{
    @Override
    protected MutableList<Integer> getCollection()
    {
        return MultiReaderFastList.newListWith(1).asReadUntouchable();
    }

    
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Override
@Test
    public void serialization()
    {
        MutableCollection<Integer> collection = this.getCollection();
        Assert.assertFalse(collection instanceof Serializable);
    }
}
