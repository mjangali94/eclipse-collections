/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block;

import java.io.IOException;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.block.function.checked.CheckedFunction;
import org.eclipse.collections.impl.block.function.checked.CheckedFunction0;
import org.eclipse.collections.impl.block.function.checked.CheckedFunction2;
import org.eclipse.collections.impl.block.predicate.checked.CheckedPredicate;
import org.eclipse.collections.impl.block.predicate.checked.CheckedPredicate2;
import org.eclipse.collections.impl.block.procedure.checked.CheckedObjectIntProcedure;
import org.eclipse.collections.impl.block.procedure.checked.CheckedProcedure;
import org.eclipse.collections.impl.block.procedure.checked.CheckedProcedure2;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.ListIterate;
import org.eclipse.collections.impl.utility.MapIterate;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;
import static org.eclipse.collections.impl.factory.Iterables.mList;

public class CheckedBlocksTest {

    @Test
    public void checkedFunction2CheckedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Function2<String, String, String> block = new CheckedFunction2<String, String, String>() {

                @Override
                public String safeValue(String argument1, String argument2) throws IOException {
                    throw new IOException("fail");
                }
            };
            block.value("1", "2");
        });
    }

    @Test
    public void checkedFunction2RuntimeException() {
        Assert.assertThrows(LocalException.class, () -> {
            Function2<String, String, String> block = new CheckedFunction2<String, String, String>() {

                @Override
                public String safeValue(String argument1, String argument2) {
                    throw new LocalException();
                }
            };
            block.value("1", "2");
        });
    }

    @Test
    public void checkedCodeBlockCheckedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Function0<String> function = new CheckedFunction0<String>() {

                @Override
                public String safeValue() throws IOException {
                    throw new IOException("fail");
                }
            };
            function.value();
        });
    }

    @Test
    public void checkedCodeBlockRuntimeException() {
        Assert.assertThrows(LocalException.class, () -> {
            Function0<String> function = new CheckedFunction0<String>() {

                @Override
                public String safeValue() {
                    throw new LocalException();
                }
            };
            function.value();
        });
    }

    @Test
    public void checkedProcedureCheckedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Procedure<String> block = new CheckedProcedure<String>() {

                @Override
                public void safeValue(String object) throws IOException {
                    throw new IOException("fail");
                }
            };
            block.value("1");
        });
    }

    @Test
    public void checkedProcedureRuntimeException() {
        Assert.assertThrows(LocalException.class, () -> {
            Procedure<String> block = new CheckedProcedure<String>() {

                @Override
                public void safeValue(String object) {
                    throw new LocalException();
                }
            };
            block.value("1");
        });
    }

    @Test
    public void checkedObjectIntProcedureCheckedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            ObjectIntProcedure<String> block = new CheckedObjectIntProcedure<String>() {

                @Override
                public void safeValue(String object, int index) throws IOException {
                    throw new IOException("fail");
                }
            };
            block.value("1", 1);
        });
    }

    @Test
    public void checkedObjectIntProcedureRuntimeException() {
        Assert.assertThrows(LocalException.class, () -> {
            ObjectIntProcedure<String> block = new CheckedObjectIntProcedure<String>() {

                @Override
                public void safeValue(String object, int index) {
                    throw new LocalException();
                }
            };
            block.value("1", 1);
        });
    }

    @Test
    public void checkedFunctionCheckedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Function<String, String> block = new CheckedFunction<String, String>() {

                @Override
                public String safeValueOf(String object) throws IOException {
                    throw new IOException("fail");
                }
            };
            block.valueOf("1");
        });
    }

    @Test
    public void checkedFunctionRuntimeException() {
        Assert.assertThrows(LocalException.class, () -> {
            Function<String, String> block = new CheckedFunction<String, String>() {

                @Override
                public String safeValueOf(String object) {
                    throw new LocalException();
                }
            };
            block.valueOf("1");
        });
    }

    @Test
    public void checkedPredicateCheckedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Predicate<String> block = new CheckedPredicate<String>() {

                @Override
                public boolean safeAccept(String object) throws IOException {
                    throw new IOException("fail");
                }
            };
            block.accept("1");
        });
    }

    @Test
    public void checkedPredicateRuntimeException() {
        Assert.assertThrows(LocalException.class, () -> {
            Predicate<String> block = new CheckedPredicate<String>() {

                @Override
                public boolean safeAccept(String object) {
                    throw new LocalException();
                }
            };
            block.accept("1");
        });
    }

    @Test
    public void checkedPredicate2CheckedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Predicate2<String, String> block = new CheckedPredicate2<String, String>() {

                @Override
                public boolean safeAccept(String object, String param) throws IOException {
                    throw new IOException("fail");
                }
            };
            block.accept("1", "2");
        });
    }

    @Test
    public void checkedPredicate2RuntimeException() {
        Assert.assertThrows(LocalException.class, () -> {
            Predicate2<String, String> block = new CheckedPredicate2<String, String>() {

                @Override
                public boolean safeAccept(String object, String param) {
                    throw new LocalException();
                }
            };
            block.accept("1", "2");
        });
    }

    @Test
    public void checkedProcedure2CheckedException() {
        Verify.assertThrowsWithCause(RuntimeException.class, IOException.class, () -> {
            Procedure2<String, String> block = new CheckedProcedure2<String, String>() {

                @Override
                public void safeValue(String object, String parameter) throws IOException {
                    throw new IOException("fail");
                }
            };
            block.value("1", "2");
        });
    }

    @Test
    public void checkedProcedure2RuntimeException() {
        Assert.assertThrows(LocalException.class, () -> {
            Procedure2<String, String> block = new CheckedProcedure2<String, String>() {

                @Override
                public void safeValue(String object, String parameter) {
                    throw new LocalException();
                }
            };
            block.value("1", "2");
        });
    }

    private static final class LocalException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        private LocalException() {
            super("fail");
        }
    }

    @Test(expected = RuntimeException.class)
    public void codeBlockFailure() {
        Function0<Object> function = new CheckedFunction0<Object>() {

            @Override
            public Object safeValue() throws InterruptedException {
                throw new InterruptedException();
            }
        };
        MutableMap<String, Object> values = UnifiedMap.newMap();
        MapIterate.getIfAbsentPut(values, "test", function);
    }

    @Test(expected = RuntimeException.class)
    public void codeBlockRuntimeException() {
        Function0<Object> function = new CheckedFunction0<Object>() {

            @Override
            public Object safeValue() {
                throw new RuntimeException();
            }
        };
        MutableMap<String, Object> values = UnifiedMap.newMap();
        MapIterate.getIfAbsentPut(values, "test", function);
    }

    @Test
    public void codeBlockSuccess() {
        Function0<Object> function = new CheckedFunction0<Object>() {

            @Override
            public Object safeValue() {
                return null;
            }
        };
        MutableMap<String, Object> values = UnifiedMap.newMap();
        MapIterate.getIfAbsentPut(values, "test", function);
    }

    @Test(expected = RuntimeException.class)
    public void procedureFailure() {
        Procedure<Object> block = new CheckedProcedure<Object>() {

            @Override
            public void safeValue(Object object) throws InterruptedException {
                throw new InterruptedException();
            }
        };
        iList("test").forEach(block);
    }

    @Test(expected = RuntimeException.class)
    public void procedureRuntimeException() {
        Procedure<Object> block = new CheckedProcedure<Object>() {

            @Override
            public void safeValue(Object object) {
                throw new RuntimeException();
            }
        };
        iList("test").forEach(block);
    }

    @Test
    public void procedureSuccess() {
        Procedure<Object> block = new CheckedProcedure<Object>() {

            @Override
            public void safeValue(Object object) {
            }
        };
        iList("test").forEach(block);
    }

    @Test(expected = RuntimeException.class)
    public void objectIntProcedureFailure() {
        ObjectIntProcedure<Object> block = new CheckedObjectIntProcedure<Object>() {

            @Override
            public void safeValue(Object object, int index) throws InterruptedException {
                throw new InterruptedException();
            }
        };
        iList("test").forEachWithIndex(block);
    }

    @Test(expected = RuntimeException.class)
    public void objectIntProcedureRuntimeException() {
        ObjectIntProcedure<Object> block = new CheckedObjectIntProcedure<Object>() {

            @Override
            public void safeValue(Object object, int index) {
                throw new RuntimeException();
            }
        };
        iList("test").forEachWithIndex(block);
    }

    @Test
    public void objectIntProcedureSuccess() {
        ObjectIntProcedure<Object> block = new CheckedObjectIntProcedure<Object>() {

            @Override
            public void safeValue(Object object, int index) {
            }
        };
        iList("test").forEachWithIndex(block);
    }

    @Test(expected = RuntimeException.class)
    public void functionFailure() {
        Function<Object, Object> block = new CheckedFunction<Object, Object>() {

            @Override
            public Object safeValueOf(Object object) throws InterruptedException {
                throw new InterruptedException();
            }
        };
        iList("test").collect(block);
    }

    @Test(expected = RuntimeException.class)
    public void functionRuntimeException() {
        Function<Object, Object> block = new CheckedFunction<Object, Object>() {

            @Override
            public Object safeValueOf(Object object) {
                throw new RuntimeException();
            }
        };
        iList("test").collect(block);
    }

    @Test
    public void functionSuccess() {
        Function<Object, Object> block = new CheckedFunction<Object, Object>() {

            @Override
            public Object safeValueOf(Object object) {
                return null;
            }
        };
        iList("test").collect(block);
    }

    @Test(expected = RuntimeException.class)
    public void predicateFailure() {
        Predicate<Object> block = new CheckedPredicate<Object>() {

            @Override
            public boolean safeAccept(Object object) throws InterruptedException {
                throw new InterruptedException();
            }
        };
        iList("test").select(block);
    }

    @Test(expected = RuntimeException.class)
    public void predicateRuntimeException() {
        Predicate<Object> block = new CheckedPredicate<Object>() {

            @Override
            public boolean safeAccept(Object object) {
                throw new RuntimeException();
            }
        };
        iList("test").select(block);
    }

    @Test
    public void predicateSuccess() {
        Predicate<String> alwaysTrueBlock = new CheckedPredicate<String>() {

            @Override
            public boolean safeAccept(String s) {
                return true;
            }
        };
        ImmutableList<String> list = iList("test");
        Assert.assertEquals(list, list.select(alwaysTrueBlock));
        Predicate<String> alwaysFalseBlock = new CheckedPredicate<String>() {

            @Override
            public boolean safeAccept(String s) {
                return false;
            }
        };
        Verify.assertEmpty(list.select(alwaysFalseBlock));
    }

    @Test(expected = RuntimeException.class)
    public void procedure2Failure() {
        Procedure2<Object, Object> block = new CheckedProcedure2<Object, Object>() {

            @Override
            public void safeValue(Object argument1, Object argument2) throws InterruptedException {
                throw new InterruptedException();
            }
        };
        ListIterate.forEachInBoth(mList("test"), mList("test"), block);
    }

    @Test(expected = RuntimeException.class)
    public void procedure2RuntimeException() {
        Procedure2<Object, Object> block = new CheckedProcedure2<Object, Object>() {

            @Override
            public void safeValue(Object argument1, Object argument2) {
                throw new RuntimeException();
            }
        };
        ListIterate.forEachInBoth(mList("test"), mList("test"), block);
    }

    @Test
    public void procedure2Success() {
        Procedure2<Object, Object> block = new CheckedProcedure2<Object, Object>() {

            @Override
            public void safeValue(Object argument1, Object argument2) {
                // nop
            }
        };
        ListIterate.forEachInBoth(mList("test"), mList("test"), block);
    }

    @Test(expected = RuntimeException.class)
    public void predicate2Failure() {
        Predicate2<Object, Object> block = new CheckedPredicate2<Object, Object>() {

            @Override
            public boolean safeAccept(Object object, Object param) throws InterruptedException {
                throw new InterruptedException();
            }
        };
        mList("test").selectWith(block, null);
    }

    @Test(expected = RuntimeException.class)
    public void predicate2RuntimeException() {
        Predicate2<Object, Object> block = new CheckedPredicate2<Object, Object>() {

            @Override
            public boolean safeAccept(Object object, Object param) {
                throw new RuntimeException();
            }
        };
        mList("test").selectWith(block, null);
    }

    @Test
    public void predicate2Success() {
        Predicate2<String, Object> alwaysTrueBlock = new CheckedPredicate2<String, Object>() {

            @Override
            public boolean safeAccept(String s, Object param) {
                return true;
            }
        };
        MutableList<String> list = mList("test");
        Assert.assertEquals(list, list.selectWith(alwaysTrueBlock, null));
        Predicate2<String, Object> alwaysFalseBlock = new CheckedPredicate2<String, Object>() {

            @Override
            public boolean safeAccept(String s, Object param) {
                return false;
            }
        };
        Verify.assertEmpty(list.selectWith(alwaysFalseBlock, null));
    }

    @Test
    public void checkedFunction2SafeValue() throws Exception {
        CheckedFunction2<Integer, Integer, Integer> checkedFunction2 = new CheckedFunction2<Integer, Integer, Integer>() {

            @Override
            public Integer safeValue(Integer argument1, Integer argument2) {
                return argument1 + argument2;
            }
        };
        Assert.assertEquals(Integer.valueOf(5), checkedFunction2.safeValue(2, 3));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CheckedBlocksTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunction2CheckedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedFunction2CheckedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunction2RuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedFunction2RuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedCodeBlockCheckedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedCodeBlockCheckedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedCodeBlockRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedCodeBlockRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedProcedureCheckedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedProcedureCheckedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedProcedureRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedProcedureRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedObjectIntProcedureCheckedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedObjectIntProcedureCheckedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedObjectIntProcedureRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedObjectIntProcedureRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunctionCheckedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedFunctionCheckedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunctionRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedFunctionRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedPredicateCheckedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedPredicateCheckedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedPredicateRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedPredicateRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedPredicate2CheckedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedPredicate2CheckedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedPredicate2RuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedPredicate2RuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedProcedure2CheckedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedProcedure2CheckedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedProcedure2RuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedProcedure2RuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_codeBlockFailure() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.codeBlockFailure);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_codeBlockRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.codeBlockRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_codeBlockSuccess() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.codeBlockSuccess);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedureFailure() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.procedureFailure);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedureRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.procedureRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedureSuccess() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.procedureSuccess);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectIntProcedureFailure() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.objectIntProcedureFailure);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectIntProcedureRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.objectIntProcedureRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectIntProcedureSuccess() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.objectIntProcedureSuccess);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_functionFailure() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.functionFailure);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_functionRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.functionRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_functionSuccess() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.functionSuccess);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicateFailure() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.predicateFailure);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicateRuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.predicateRuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicateSuccess() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.predicateSuccess);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedure2Failure() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.procedure2Failure);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedure2RuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.procedure2RuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedure2Success() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.procedure2Success);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicate2Failure() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.predicate2Failure);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicate2RuntimeException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.predicate2RuntimeException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicate2Success() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.predicate2Success);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunction2SafeValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.checkedFunction2SafeValue);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> payload) throws java.lang.Throwable {
            this.instance = new CheckedBlocksTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedFunction2CheckedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedFunction2RuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedCodeBlockCheckedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedCodeBlockRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedProcedureCheckedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedProcedureRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedObjectIntProcedureCheckedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedObjectIntProcedureRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedFunctionCheckedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedFunctionRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedPredicateCheckedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedPredicateRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedPredicate2CheckedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedPredicate2RuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedProcedure2CheckedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedProcedure2RuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> codeBlockFailure;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> codeBlockRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> codeBlockSuccess;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> procedureFailure;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> procedureRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> procedureSuccess;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> objectIntProcedureFailure;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> objectIntProcedureRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> objectIntProcedureSuccess;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> functionFailure;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> functionRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> functionSuccess;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> predicateFailure;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> predicateRuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> predicateSuccess;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> procedure2Failure;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> procedure2RuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> procedure2Success;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> predicate2Failure;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> predicate2RuntimeException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> predicate2Success;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CheckedBlocksTest> checkedFunction2SafeValue;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.checkedFunction2CheckedException = CheckedBlocksTest::checkedFunction2CheckedException;
            this.payloads.checkedFunction2RuntimeException = CheckedBlocksTest::checkedFunction2RuntimeException;
            this.payloads.checkedCodeBlockCheckedException = CheckedBlocksTest::checkedCodeBlockCheckedException;
            this.payloads.checkedCodeBlockRuntimeException = CheckedBlocksTest::checkedCodeBlockRuntimeException;
            this.payloads.checkedProcedureCheckedException = CheckedBlocksTest::checkedProcedureCheckedException;
            this.payloads.checkedProcedureRuntimeException = CheckedBlocksTest::checkedProcedureRuntimeException;
            this.payloads.checkedObjectIntProcedureCheckedException = CheckedBlocksTest::checkedObjectIntProcedureCheckedException;
            this.payloads.checkedObjectIntProcedureRuntimeException = CheckedBlocksTest::checkedObjectIntProcedureRuntimeException;
            this.payloads.checkedFunctionCheckedException = CheckedBlocksTest::checkedFunctionCheckedException;
            this.payloads.checkedFunctionRuntimeException = CheckedBlocksTest::checkedFunctionRuntimeException;
            this.payloads.checkedPredicateCheckedException = CheckedBlocksTest::checkedPredicateCheckedException;
            this.payloads.checkedPredicateRuntimeException = CheckedBlocksTest::checkedPredicateRuntimeException;
            this.payloads.checkedPredicate2CheckedException = CheckedBlocksTest::checkedPredicate2CheckedException;
            this.payloads.checkedPredicate2RuntimeException = CheckedBlocksTest::checkedPredicate2RuntimeException;
            this.payloads.checkedProcedure2CheckedException = CheckedBlocksTest::checkedProcedure2CheckedException;
            this.payloads.checkedProcedure2RuntimeException = CheckedBlocksTest::checkedProcedure2RuntimeException;
            this.payloads.codeBlockFailure = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::codeBlockFailure, java.lang.RuntimeException.class);
            this.payloads.codeBlockRuntimeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::codeBlockRuntimeException, java.lang.RuntimeException.class);
            this.payloads.codeBlockSuccess = CheckedBlocksTest::codeBlockSuccess;
            this.payloads.procedureFailure = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::procedureFailure, java.lang.RuntimeException.class);
            this.payloads.procedureRuntimeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::procedureRuntimeException, java.lang.RuntimeException.class);
            this.payloads.procedureSuccess = CheckedBlocksTest::procedureSuccess;
            this.payloads.objectIntProcedureFailure = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::objectIntProcedureFailure, java.lang.RuntimeException.class);
            this.payloads.objectIntProcedureRuntimeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::objectIntProcedureRuntimeException, java.lang.RuntimeException.class);
            this.payloads.objectIntProcedureSuccess = CheckedBlocksTest::objectIntProcedureSuccess;
            this.payloads.functionFailure = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::functionFailure, java.lang.RuntimeException.class);
            this.payloads.functionRuntimeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::functionRuntimeException, java.lang.RuntimeException.class);
            this.payloads.functionSuccess = CheckedBlocksTest::functionSuccess;
            this.payloads.predicateFailure = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::predicateFailure, java.lang.RuntimeException.class);
            this.payloads.predicateRuntimeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::predicateRuntimeException, java.lang.RuntimeException.class);
            this.payloads.predicateSuccess = CheckedBlocksTest::predicateSuccess;
            this.payloads.procedure2Failure = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::procedure2Failure, java.lang.RuntimeException.class);
            this.payloads.procedure2RuntimeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::procedure2RuntimeException, java.lang.RuntimeException.class);
            this.payloads.procedure2Success = CheckedBlocksTest::procedure2Success;
            this.payloads.predicate2Failure = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::predicate2Failure, java.lang.RuntimeException.class);
            this.payloads.predicate2RuntimeException = new se.chalmers.ju2jmh.api.ExceptionTest<>(CheckedBlocksTest::predicate2RuntimeException, java.lang.RuntimeException.class);
            this.payloads.predicate2Success = CheckedBlocksTest::predicate2Success;
            this.payloads.checkedFunction2SafeValue = CheckedBlocksTest::checkedFunction2SafeValue;
        }
    }
}
