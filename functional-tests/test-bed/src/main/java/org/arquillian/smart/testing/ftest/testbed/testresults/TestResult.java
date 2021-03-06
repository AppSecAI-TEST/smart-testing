package org.arquillian.smart.testing.ftest.testbed.testresults;

import java.util.Arrays;
import java.util.Objects;

public class TestResult {

    private String className;
    private String testMethod;
    private Status result;

    public TestResult(String className, String testMethod, Status status) {
        this.className = className;
        this.testMethod = testMethod;
        this.result = status;
    }

    public String getClassName() {
        return className;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public Status getStatus() {
        return result;
    }

    public void setStatus(Status result) {
        this.result = result;
    }

    public boolean isFailing() {
        return this.result == Status.ERROR || this.result == Status.FAILURE || this.result == Status.RE_RUN_FAILURE;
    }

    // TODO we are operating on a class level now....
    public static TestResult from(String ... testResultParts) {
        if (testResultParts.length > 2) {
            throw new IllegalArgumentException(
                "Too many arguments passed to create TestResult. Expected to get status code and name, got [" + Arrays.toString(testResultParts) + "]");
        }
        return new TestResult(testResultParts[1], "*", Status.from(testResultParts[0]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TestResult that = (TestResult) o;
        return Objects.equals(getClassName(), that.getClassName()) &&
            Objects.equals(getTestMethod(), that.getTestMethod()) &&
            result == that.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClassName(), getTestMethod(), result);
    }

    @Override
    public String toString() {
        return "TestResult{" +
            "className='" + className + '\'' +
            ", testMethod='" + testMethod + '\'' +
            ", result=" + result +
            '}';
    }
}
