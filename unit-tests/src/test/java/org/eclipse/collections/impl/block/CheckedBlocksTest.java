/*
 * Copyright (c) 2015 Goldman Sachs.
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
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
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
            CheckedFunction2<String, String, String> block = new CheckedFunction2<String, String, String>() {

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
            CheckedFunction2<String, String, String> block = new CheckedFunction2<String, String, String>() {

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
            CheckedFunction0<String> function = new CheckedFunction0<String>() {

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
            CheckedFunction0<String> function = new CheckedFunction0<String>() {

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
            CheckedProcedure<String> block = new CheckedProcedure<String>() {

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
            CheckedProcedure<String> block = new CheckedProcedure<String>() {

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
            CheckedObjectIntProcedure<String> block = new CheckedObjectIntProcedure<String>() {

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
            CheckedObjectIntProcedure<String> block = new CheckedObjectIntProcedure<String>() {

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
            CheckedFunction<String, String> block = new CheckedFunction<String, String>() {

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
            CheckedFunction<String, String> block = new CheckedFunction<String, String>() {

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
            CheckedPredicate<String> block = new CheckedPredicate<String>() {

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
            CheckedPredicate<String> block = new CheckedPredicate<String>() {

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
            CheckedPredicate2<String, String> block = new CheckedPredicate2<String, String>() {

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
            CheckedPredicate2<String, String> block = new CheckedPredicate2<String, String>() {

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
            CheckedProcedure2<String, String> block = new CheckedProcedure2<String, String>() {

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
            CheckedProcedure2<String, String> block = new CheckedProcedure2<String, String>() {

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
        Predicate<Object> block = new CheckedPredicate<Object>() {

            @Override
            public boolean safeAccept(Object object) {
                return true;
            }
        };
        iList("test").select(block);
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
        Predicate2<Object, Object> block = new CheckedPredicate2<Object, Object>() {

            @Override
            public boolean safeAccept(Object object, Object param) {
                return true;
            }
        };
        mList("test").selectWith(block, null);
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
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunction2CheckedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedFunction2CheckedException, this.description("checkedFunction2CheckedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunction2RuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedFunction2RuntimeException, this.description("checkedFunction2RuntimeException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedCodeBlockCheckedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedCodeBlockCheckedException, this.description("checkedCodeBlockCheckedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedCodeBlockRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedCodeBlockRuntimeException, this.description("checkedCodeBlockRuntimeException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedProcedureCheckedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedProcedureCheckedException, this.description("checkedProcedureCheckedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedProcedureRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedProcedureRuntimeException, this.description("checkedProcedureRuntimeException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedObjectIntProcedureCheckedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedObjectIntProcedureCheckedException, this.description("checkedObjectIntProcedureCheckedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedObjectIntProcedureRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedObjectIntProcedureRuntimeException, this.description("checkedObjectIntProcedureRuntimeException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunctionCheckedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedFunctionCheckedException, this.description("checkedFunctionCheckedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunctionRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedFunctionRuntimeException, this.description("checkedFunctionRuntimeException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedPredicateCheckedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedPredicateCheckedException, this.description("checkedPredicateCheckedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedPredicateRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedPredicateRuntimeException, this.description("checkedPredicateRuntimeException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedPredicate2CheckedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedPredicate2CheckedException, this.description("checkedPredicate2CheckedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedPredicate2RuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedPredicate2RuntimeException, this.description("checkedPredicate2RuntimeException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedProcedure2CheckedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedProcedure2CheckedException, this.description("checkedProcedure2CheckedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedProcedure2RuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedProcedure2RuntimeException, this.description("checkedProcedure2RuntimeException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_codeBlockFailure() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::codeBlockFailure, this.description("codeBlockFailure"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_codeBlockRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::codeBlockRuntimeException, this.description("codeBlockRuntimeException"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_codeBlockSuccess() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::codeBlockSuccess, this.description("codeBlockSuccess"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedureFailure() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::procedureFailure, this.description("procedureFailure"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedureRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::procedureRuntimeException, this.description("procedureRuntimeException"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedureSuccess() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::procedureSuccess, this.description("procedureSuccess"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectIntProcedureFailure() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::objectIntProcedureFailure, this.description("objectIntProcedureFailure"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectIntProcedureRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::objectIntProcedureRuntimeException, this.description("objectIntProcedureRuntimeException"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_objectIntProcedureSuccess() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::objectIntProcedureSuccess, this.description("objectIntProcedureSuccess"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_functionFailure() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::functionFailure, this.description("functionFailure"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_functionRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::functionRuntimeException, this.description("functionRuntimeException"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_functionSuccess() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::functionSuccess, this.description("functionSuccess"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicateFailure() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::predicateFailure, this.description("predicateFailure"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicateRuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::predicateRuntimeException, this.description("predicateRuntimeException"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicateSuccess() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::predicateSuccess, this.description("predicateSuccess"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedure2Failure() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::procedure2Failure, this.description("procedure2Failure"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedure2RuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::procedure2RuntimeException, this.description("procedure2RuntimeException"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_procedure2Success() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::procedure2Success, this.description("procedure2Success"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicate2Failure() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::predicate2Failure, this.description("predicate2Failure"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicate2RuntimeException() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::predicate2RuntimeException, this.description("predicate2RuntimeException"), java.lang.RuntimeException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_predicate2Success() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::predicate2Success, this.description("predicate2Success"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_checkedFunction2SafeValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::checkedFunction2SafeValue, this.description("checkedFunction2SafeValue"));
        }

        private CheckedBlocksTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CheckedBlocksTest();
        }

        @java.lang.Override
        public CheckedBlocksTest implementation() {
            return this.implementation;
        }
    }
}
