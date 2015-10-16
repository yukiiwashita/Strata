/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.math.impl.minimization;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import com.opengamma.strata.math.impl.function.Function1D;
import com.opengamma.strata.math.impl.matrix.DoubleArray;

/**
 * Abstract test.
 */
@Test
public abstract class MultidimensionalMinimizerWithGradientTestCase {

  protected void assertSolvingRosenbrock(final MinimizerWithGradient<Function1D<DoubleArray, Double>, Function1D<DoubleArray, DoubleArray>, DoubleArray> minimzer, final double tol) {
    final DoubleArray start = DoubleArray.of(-1.0, 1.0);
    final DoubleArray solution = minimzer.minimize(MinimizationTestFunctions.ROSENBROCK, MinimizationTestFunctions.ROSENBROCK_GRAD, start);
    assertEquals(1.0, solution.get(0), tol);
    assertEquals(1.0, solution.get(1), tol);
  }

  protected void assertSolvingRosenbrockWithoutGradient(final MinimizerWithGradient<Function1D<DoubleArray, Double>, Function1D<DoubleArray, DoubleArray>, DoubleArray> minimzer,
      final double tol) {
    final DoubleArray start = DoubleArray.of(-1.0, 1.0);
    final DoubleArray solution = minimzer.minimize(MinimizationTestFunctions.ROSENBROCK, start);
    assertEquals(1.0, solution.get(0), tol);
    assertEquals(1.0, solution.get(1), tol);
  }

  protected void assertSolvingCoupledRosenbrock(final MinimizerWithGradient<Function1D<DoubleArray, Double>, Function1D<DoubleArray, DoubleArray>, DoubleArray> minimzer, final double tol) {
    final DoubleArray start = DoubleArray.of(-1.0, 1.0, -1.0, 1.0, -1.0, 1.0, 1.0);
    final DoubleArray solution = minimzer.minimize(MinimizationTestFunctions.COUPLED_ROSENBROCK, MinimizationTestFunctions.COUPLED_ROSENBROCK_GRAD, start);
    for (int i = 0; i < solution.size(); i++) {
      assertEquals(1.0, solution.get(i), tol);
    }
  }

  protected void assertSolvingCoupledRosenbrockWithoutGradient(final MinimizerWithGradient<Function1D<DoubleArray, Double>, Function1D<DoubleArray, DoubleArray>, DoubleArray> minimzer,
      final double tol) {
    final DoubleArray start = DoubleArray.of(-1.0, 1.0, -1.0, 1.0, -1.0, 1.0, 1.0);
    final DoubleArray solution = minimzer.minimize(MinimizationTestFunctions.COUPLED_ROSENBROCK, start);
    for (int i = 0; i < solution.size(); i++) {
      assertEquals(1.0, solution.get(i), tol);
    }
  }
}