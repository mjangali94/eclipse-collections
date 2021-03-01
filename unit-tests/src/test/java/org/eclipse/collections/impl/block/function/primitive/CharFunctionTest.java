/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.block.function.primitive;

import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharFunction}.
 *
 * @deprecated in 6.2
 */
@Deprecated
public class CharFunctionTest
{
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void toUppercase()
    {
        Assert.assertEquals('A', CharFunction.TO_UPPERCASE.valueOf('a'));
        Assert.assertEquals('A', CharFunction.TO_UPPERCASE.valueOf('A'));
        Assert.assertEquals('1', CharFunction.TO_UPPERCASE.valueOf('1'));
    }

    @Test
    public void toLowercase()
    {
        Assert.assertEquals('a', CharFunction.TO_LOWERCASE.valueOf('a'));
        Assert.assertEquals('a', CharFunction.TO_LOWERCASE.valueOf('A'));
        Assert.assertEquals('1', CharFunction.TO_LOWERCASE.valueOf('1'));
    }
}
