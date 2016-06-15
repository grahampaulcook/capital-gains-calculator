/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package config

import org.joda.time.DateTime
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

class ParametersSpec extends UnitSpec with WithFakeApplication {

  "validating non-year specific parameters" should {

    "return 2015-04-06 string for the start of the tax" in {
      YearlyParameters.getParameters(0).startOfTax shouldEqual "2015-04-06"
    }

    "return a date of 2015-04-06 for the start of the tax date" in {
      YearlyParameters.getParameters(0).startOfTaxDateTime shouldEqual DateTime.parse("2015-04-06")
    }

    "return 18 as the value of eighteenMonths" in {
      YearlyParameters.getParameters(0).eighteenMonths shouldEqual 18
    }

  }

  "validating 2016/2017 parameters" should {

    "return 2017 for the tax year" in {
      ParametersFor20162017.taxYear shouldBe 2017
    }

    "return 18 as the basic percentage rate for the tax year" in {
      ParametersFor20162017.basicRate shouldBe 0.18
      ParametersFor20162017.basicRatePercentage shouldBe 18
    }

    "return 28 as the higher percentage rate for the tax year" in {
      ParametersFor20162017.higherRate shouldBe 0.28
      ParametersFor20162017.higherRatePercentage shouldBe 28
    }

    "return 11100 as the maximum Annual Excempt Amount" in {
      ParametersFor20162017.maxAnnualExemptAmount shouldBe 11100
    }

    "return 5550 as the non-vulnerable trustee Annual Excempt Amount" in {
      ParametersFor20162017.notVulnerableMaxAnnualExemptAmount shouldBe 5550
    }

    "return 32000 as the basic rate band" in {
      ParametersFor20162017.basicRateBand shouldBe 32000
    }

  }

  "Validating the getParameters method" when {

    "calling with the year 2017" should {

      "return 2017 for the tax year" in {
        YearlyParameters.getParameters(2017).taxYear shouldBe 2017
      }

      "return 18 as the basic percentage rate for the tax year" in {
        YearlyParameters.getParameters(2017).basicRate shouldBe 0.18
        YearlyParameters.getParameters(2017).basicRatePercentage shouldBe 18
      }

      "return 28 as the higher percentage rate for the tax year" in {
        YearlyParameters.getParameters(2017).higherRate shouldBe 0.28
        YearlyParameters.getParameters(2017).higherRatePercentage shouldBe 28
      }

      "return 11100 as the maximum Annual Excempt Amount" in {
        YearlyParameters.getParameters(2017).maxAnnualExemptAmount shouldBe 11100
      }

      "return 5550 as the non-vulnerable trustee Annual Excempt Amount" in {
        YearlyParameters.getParameters(2017).notVulnerableMaxAnnualExemptAmount shouldBe 5550
      }

      "return 32000 as the basic rate band" in {
        YearlyParameters.getParameters(2017).basicRateBand shouldBe 32000
      }

    }

  }

}
