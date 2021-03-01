/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

public class BooleanHashSetTest extends AbstractBooleanSetTestCase
{
    @Override
    protected BooleanHashSet classUnderTest()
    {
        return BooleanHashSet.newSetWith(true, false, true);
    }

    @Override
    protected BooleanHashSet newWith(boolean... elements)
    {
        return BooleanHashSet.newSetWith(elements);
    }

        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void construction() throws Exception
    {
        Field table = BooleanHashSet.class.getDeclaredField("state");
        table.setAccessible(true);
        Assert.assertEquals(0, table.get(new BooleanHashSet()));
    }

    @Override
    @Test
    public void newCollection()
    {
        super.newCollection();
        BooleanHashSet set0 = this.newWith();
        BooleanHashSet set1 = this.newWith(false);
        BooleanHashSet set2 = this.newWith(true);
        BooleanHashSet set3 = this.newWith(true, false);

        BooleanHashSet setFromList = BooleanHashSet.newSet(BooleanArrayList.newListWith(true, true, false));
        BooleanHashSet setFromSet0 = BooleanHashSet.newSet(set0);
        BooleanHashSet setFromSet1 = BooleanHashSet.newSet(set1);
        BooleanHashSet setFromSet2 = BooleanHashSet.newSet(set2);
        BooleanHashSet setFromSet3 = BooleanHashSet.newSet(set3);
        Assert.assertEquals(set3, setFromList);
        Assert.assertEquals(set0, setFromSet0);
        Assert.assertEquals(set1, setFromSet1);
        Assert.assertEquals(set2, setFromSet2);
        Assert.assertEquals(set3, setFromSet3);
    }

    @Override
    @Test
    public void booleanIterator_with_remove()
    {
        super.booleanIterator_with_remove();

        BooleanHashSet falseSet = this.newWith(false);
        MutableBooleanIterator mutableBooleanIterator = falseSet.booleanIterator();
        Assert.assertTrue(mutableBooleanIterator.hasNext());
        Assert.assertFalse(mutableBooleanIterator.next());
        mutableBooleanIterator.remove();
        Verify.assertEmpty(falseSet);
        Assert.assertThrows(NoSuchElementException.class, mutableBooleanIterator::next);
        Assert.assertThrows(IllegalStateException.class, mutableBooleanIterator::remove);
        BooleanHashSet trueSet = this.newWith(true);
        mutableBooleanIterator = trueSet.booleanIterator();
        Assert.assertTrue(mutableBooleanIterator.hasNext());
        Assert.assertTrue(mutableBooleanIterator.next());
        mutableBooleanIterator.remove();
        Verify.assertEmpty(trueSet);
        Assert.assertThrows(NoSuchElementException.class, mutableBooleanIterator::next);
        Assert.assertThrows(IllegalStateException.class, mutableBooleanIterator::remove);
        BooleanHashSet emptySet = new BooleanHashSet();
        mutableBooleanIterator = emptySet.booleanIterator();
        Assert.assertFalse(mutableBooleanIterator.hasNext());
        Verify.assertEmpty(emptySet);
        Assert.assertThrows(NoSuchElementException.class, mutableBooleanIterator::next);
        Assert.assertThrows(IllegalStateException.class, mutableBooleanIterator::remove);
    }
}
