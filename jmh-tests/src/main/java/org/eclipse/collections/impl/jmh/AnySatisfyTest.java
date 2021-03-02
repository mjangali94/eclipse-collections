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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.rules.TestName;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.collections.impl.myBlackhole;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.eclipse.collections.impl.myBlackhole;
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class AnySatisfyTest {
	private static final int SIZE = 1_000_000;
	private static final int BATCH_SIZE = 10_000;
	private final List<Integer> integersJDK = new ArrayList<>(Interval.oneTo(SIZE));
	private final FastList<Integer> integersEC = FastList.newList(Interval.oneTo(SIZE));

	private ExecutorService executorService;



	

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

	@Setup
	public void setUp() {
		this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}

	@TearDown
	public void tearDown() throws InterruptedException {
		this.executorService.shutdownNow();
		this.executorService.awaitTermination(1L, TimeUnit.SECONDS);
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_serial_lazy_jdk() {
		Assert.assertTrue(this.integersJDK.stream().anyMatch(each -> each > SIZE / 2));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_serial_lazy_streams_ec() {
		Assert.assertTrue(this.integersEC.stream().anyMatch(each -> each > SIZE / 2));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_serial_lazy_jdk() {
		Assert.assertFalse(this.integersJDK.stream().anyMatch(each -> each < 0));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_serial_lazy_streams_ec() {
		Assert.assertFalse(this.integersEC.stream().anyMatch(each -> each < 0));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_serial_eager_ec() {
		Assert.assertTrue(this.integersEC.anySatisfy(each -> each > SIZE / 2));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_serial_eager_ec() {
		Assert.assertFalse(this.integersEC.anySatisfy(each -> each < 0));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_serial_lazy_ec() {
		Assert.assertTrue(this.integersEC.asLazy().anySatisfy(each -> each > SIZE / 2));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_serial_lazy_ec() {
		Assert.assertFalse(this.integersEC.asLazy().anySatisfy(each -> each < 0));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_serial_eager_scala() {
		AnySatisfyScalaTest.short_circuit_middle_serial_eager_scala();
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_serial_eager_scala() {
		AnySatisfyScalaTest.process_all_serial_eager_scala();
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_serial_lazy_scala() {
		AnySatisfyScalaTest.short_circuit_middle_serial_lazy_scala();
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_serial_lazy_scala() {
		AnySatisfyScalaTest.process_all_serial_lazy_scala();
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_parallel_lazy_jdk() {
		Assert.assertTrue(this.integersJDK.parallelStream().anyMatch(each -> each == SIZE / 2 - 1));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_parallel_lazy_streams_ec() {
		Assert.assertTrue(this.integersEC.parallelStream().anyMatch(each -> each == SIZE / 2 - 1));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_parallel_lazy_jdk() {
		Assert.assertFalse(this.integersJDK.parallelStream().anyMatch(each -> each < 0));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_parallel_lazy_streams_ec() {
		Assert.assertFalse(this.integersEC.parallelStream().anyMatch(each -> each < 0));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_parallel_lazy_ec() {
		Assert.assertTrue(
				this.integersEC.asParallel(this.executorService, BATCH_SIZE).anySatisfy(each -> each == SIZE / 2 - 1));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_parallel_lazy_ec() {
		Assert.assertFalse(this.integersEC.asParallel(this.executorService, BATCH_SIZE).anySatisfy(each -> each < 0));
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void short_circuit_middle_parallel_lazy_scala() {
		AnySatisfyScalaTest.short_circuit_middle_parallel_lazy_scala();
	}

	@Benchmark
	@OperationsPerInvocation(1)
	public void process_all_parallel_lazy_scala() {
		AnySatisfyScalaTest.process_all_parallel_lazy_scala();
	}
}
