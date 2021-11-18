package com.invoices;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
  /**
   * test sprawdzajacy czy produkt dobrze oblicza swoj koszt
   */
  @Test
  public void testSummarizedCost() {
    Product testproduct = new Product(7,"test",25);
    Assert.assertEquals(7 * 25f, testproduct.summarizedCost(),0);
  }
}