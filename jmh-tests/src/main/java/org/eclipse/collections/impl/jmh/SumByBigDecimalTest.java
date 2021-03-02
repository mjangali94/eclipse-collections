/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.jmh;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.myBlackhole;
import org.eclipse.collections.impl.jmh.domain.Account;
import org.eclipse.collections.impl.jmh.domain.Position;
import org.eclipse.collections.impl.jmh.domain.Positions;
import org.eclipse.collections.impl.jmh.domain.Product;

import org.eclipse.collections.impl.parallel.ParallelIterate;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.Assert;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SumByBigDecimalTest 
{
    private final Positions positions = new Positions().shuffle();
	@TearDown(Level.Trial)
public void nameLogger() throws InterruptedException {
	FileWriter fw=null;
	try {
		fw = new FileWriter("tmp2.csv", true);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		fw.write(this.getClass().getName() + "." + ","
				+ myBlackhole.hitting_count() + "\n");
	} catch (Exception e) {
	}
	try {
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
    @Benchmark @OperationsPerInvocation(1) 
    public MutableMap<Product, BigDecimal> sumByBigDecimalProduct_serial_eager_ec()
    {
        return Iterate.sumByBigDecimal(this.positions.getEcPositions(), Position::getProduct, Position::getPreciseMarketValue);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public MutableMap<Product, BigDecimal> sumByBigDecimalProduct_parallel_eager_ec()
    {
        return ParallelIterate.sumByBigDecimal(this.positions.getEcPositions(), Position::getProduct, Position::getPreciseMarketValue);
    }

    @Test
    public void sumByProduct_ec()
    {
        Assert.assertEquals(
                this.sumByBigDecimalProduct_parallel_eager_ec(),
                this.sumByBigDecimalProduct_serial_eager_ec());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public MutableMap<Account, BigDecimal> sumByBigDecimalAccount_serial_eager_ec()
    {
        return Iterate.sumByBigDecimal(this.positions.getEcPositions(), Position::getAccount, Position::getPreciseMarketValue);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public MutableMap<Account, BigDecimal> sumByBigDecimalAccount_parallel_eager_ec()
    {
        return ParallelIterate.sumByBigDecimal(this.positions.getEcPositions(), Position::getAccount, Position::getPreciseMarketValue);
    }

    @Test
    public void sumByAccount_ec()
    {
        Assert.assertEquals(
                this.sumByBigDecimalAccount_parallel_eager_ec(),
                this.sumByBigDecimalAccount_serial_eager_ec());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public MutableMap<String, BigDecimal> sumByBigDecimalCategory_serial_eager_ec()
    {
        return Iterate.sumByBigDecimal(this.positions.getEcPositions(), Position::getCategory, Position::getPreciseMarketValue);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public MutableMap<String, BigDecimal> sumByBigDecimalCategory_parallel_eager_ec()
    {
        return ParallelIterate.sumByBigDecimal(this.positions.getEcPositions(), Position::getCategory, Position::getPreciseMarketValue);
    }

    @Test
    public void sumByCategory_ec()
    {
        Assert.assertEquals(
                this.sumByBigDecimalCategory_parallel_eager_ec(),
                this.sumByBigDecimalCategory_serial_eager_ec());
    }
}
