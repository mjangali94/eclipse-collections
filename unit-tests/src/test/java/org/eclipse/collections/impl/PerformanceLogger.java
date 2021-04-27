/**
 * Copyright (c) 2016-present, RxJava Contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eclipse.collections.impl;

import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;


public class org.eclipse.collections.impl.PerformanceLogger implements TestRule {

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				FileWriter mydata = new FileWriter("myData.csv",true);
				
					long start2 = System.nanoTime();
					long throughput2 = 0;
					long TIME2 = 0;
					while (TIME2 < 10000000000L) {
						try {
							base.evaluate();
						} finally {

							throughput2 += 1;
						}
						
							TIME2 = System.nanoTime() - start2;
					}

				
				String compeletName = description.getDisplayName();
				String test = compeletName.substring(0, compeletName.indexOf("("));
				String packageName = compeletName.substring(compeletName.indexOf("(") + 1,
						compeletName.lastIndexOf(")"));
				try {
				mydata.write(packageName + "." + test +", ");
				}catch (Exception e) {
					// TODO: handle exception
				}
				for (int i = 0; i < 10; i++) {
					long start = System.nanoTime();
					double throughput = 0.0;
					long TIME = 0;
					while (TIME < 1000000000L) {
						try {
							base.evaluate();
						} finally {

							throughput += 1.0;
						}

						TIME = System.nanoTime() - start;
					}

					
					try {
					mydata.write(throughput / ((TIME) / 1000000000)+", ");
					}catch (Exception e) {
						// TODO: handle exception
					}
					

				}
				try {
					mydata.write("\n");
					}catch (Exception e) {
						// TODO: handle exception
					}
				mydata.close();
			}
		};
	}
}