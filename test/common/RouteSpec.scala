/*
 * Copyright 2020 HM Revenue & Customs
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

package common

import models.nonResident.{OtherReliefsModel, PrivateResidenceReliefModel}
import models.resident.properties.PropertyTotalGainModel
import models.resident.shares.TotalGainModel
import org.joda.time.DateTime
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import play.api.mvc.QueryStringBindable
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

class RouteSpec extends UnitSpec with WithFakeApplication with MockitoSugar {

  "The route for calculate gain after prr for non-resident properties" should {
    val testDate = Some(new DateTime("2001-01-01"))
    lazy val url = controllers.nonresident.routes.CalculatorController.
      calculateTaxableGainAfterPRR(1, 1, 1, 1, 1, Some(1), 1, testDate, testDate, 1, true, 1, 1).url
    lazy val queryStringParameters = url.substring(url.indexOf('?'))

    "have the path /non-resident/calculate-gain-after-prr" in {
      url should startWith("/capital-gains-calculator/non-resident/calculate-gain-after-prr")
    }

    "have query string parameters" in {
      queryStringParameters should not be empty
    }

    "include the disposal value query string parameter" in {
      url should include("disposalValue=1.0")
    }

    "include the disposal costs query string parameter" in {
      queryStringParameters should include("disposalCosts=1.0")
    }

    "include the acquisition value query string parameter" in {
      queryStringParameters should include("acquisitionValue=1.0")
    }

    "include the acquisition costs query string parameter" in {
      queryStringParameters should include("acquisitionCosts=1.0")
    }

    "include the improvements query string parameter" in {
      queryStringParameters should include("improvements=1.0")
    }

    "include the rebased value query string parameter" in {
      queryStringParameters should include("rebasedValue=1.0")
    }

    "include the disposal date query string parameter" in {
      queryStringParameters should include("disposalDate=2001-1-1")
    }

    "include the acquisition date query string parameter" in {
      queryStringParameters should include("acquisitionDate=2001-1-1")
    }

    "include the improvements after the tax started query string parameter" in {
      queryStringParameters should include("improvementsAfterTaxStarted=1.0")
    }

    "include the claiming PRR query string parameter" in {
      queryStringParameters should include("claimingPRR=true")
    }

    "include the days claimed query string parameter" in {
      queryStringParameters should include("daysClaimed=1.0")
    }

    "include the days claimed after the tax started query string parameter" in {
      queryStringParameters should include("daysClaimedAfter=1.0")
    }
  }

  "The route for calculate tax owed for non-resident properties" should {
    val testDate = Some(new DateTime("2001-01-01"))
    lazy val url = controllers.nonresident.routes.CalculatorController.calculateTaxOwed(1, 1, 1, 1, 1, Some(1), 1, testDate.get, testDate,
      1, PrivateResidenceReliefModel(claimingPRR = true, Some(1), Some(1)), 1, 1, 1, 1, 1, 1, OtherReliefsModel(1, 1, 1)).url
    lazy val queryStringParameters = url.substring(url.indexOf('?'))

    "have the path /non-resident/calculate-gain-after-prr" in {
      url should startWith("/capital-gains-calculator/non-resident/calculate-tax-owed")
    }

    "have query string parameters" in {
      queryStringParameters should not be empty
    }

    "include the disposal value query string parameter" in {
      url should include("disposalValue=1.0")
    }

    "include the disposal costs query string parameter" in {
      queryStringParameters should include("disposalCosts=1.0")
    }

    "include the acquisition value query string parameter" in {
      queryStringParameters should include("acquisitionValue=1.0")
    }

    "include the acquisition costs query string parameter" in {
      queryStringParameters should include("acquisitionCosts=1.0")
    }

    "include the improvements query string parameter" in {
      queryStringParameters should include("improvements=1.0")
    }

    "include the rebased value query string parameter" in {
      queryStringParameters should include("rebasedValue=1.0")
    }

    "include the disposal date query string parameter" in {
      queryStringParameters should include("disposalDate=2001-1-1")
    }

    "include the acquisition date query string parameter" in {
      queryStringParameters should include("acquisitionDate=2001-1-1")
    }

    "include the improvements after the tax started query string parameter" in {
      queryStringParameters should include("improvementsAfterTaxStarted=1.0")
    }

    "include the claiming PRR query string parameter" in {
      queryStringParameters should include("claimingPRR=true")
    }

    "include the days claimed query string parameter" in {
      queryStringParameters should include("daysClaimed=1.0")
    }

    "include the days claimed after the tax started query string parameter" in {
      queryStringParameters should include("daysClaimedAfter=1.0")
    }

    "include the current income query string parameter" in {
      queryStringParameters should include("currentIncome=1.0")
    }

    "include the personal allowance query string parameter" in {
      queryStringParameters should include("personalAllowanceAmt=1.0")
    }

    "include the allowable loss query string parameter" in {
      queryStringParameters should include("allowableLoss=1.0")
    }

    "include the previous gain query string parameter" in {
      queryStringParameters should include("previousGain=1.0")
    }

    "include the annual exempt amount query string parameter" in {
      queryStringParameters should include("annualExemptAmount=1.0")
    }

    "include the brought forward loss query string parameter" in {
      queryStringParameters should include("broughtForwardLoss=1.0")
    }

    "include the other reliefs flat query string parameter" in {
      queryStringParameters should include("otherReliefsFlat=1.0")
    }

    "include the other reliefs rebased query string parameter" in {
      queryStringParameters should include("otherReliefsRebased=1.0")
    }

    "include the other reliefs time apportioned query string parameter" in {
      queryStringParameters should include("otherReliefsTimeApportioned=1.0")
    }
  }

  "The route for calculate total costs for non-resident properties" should {

    lazy val url = controllers.nonresident.routes.CalculatorController.calculateTotalCosts(1000.00, 500.00, 300.00).url
    lazy val queryStringParameters = url.substring(url.indexOf('?'))

    "have the path /non-resident/calculate-total-costs" in {
      url should startWith("/capital-gains-calculator/non-resident/calculate-total-costs")
    }

    "have query string parameters" in {
      queryStringParameters should not be empty
    }

    "include the disposal costs query string parameter" in {
      queryStringParameters should include("disposalCosts=1000.0")
    }

    "include the acquisition costs  query string parameter" in {
      queryStringParameters should include("acquisitionCosts=500.0")
    }

    "include the improvements value query string parameter" in {
      queryStringParameters should include("improvements=300.0")
    }
  }

  "The route for calculate total costs for resident properties" should {

    val totalGainModel = TotalGainModel(0, 0, 0, 0)
    val propertyTotalGainModel = PropertyTotalGainModel(totalGainModel, 0)

    lazy val url = controllers.resident.properties.routes.CalculatorController.calculateTotalCosts(propertyTotalGainModel).url

    "be equal to '/capital-gains-calculator/calculate-total-costs'" in {
      url should startWith("/capital-gains-calculator/calculate-total-costs")
    }

    "include the disposal value" in {
      url should include("disposalValue=0")
    }

    "include the disposal costs" in {
      url should include("disposalCosts=0")
    }

    "include the acquisition value" in {
      url should include("acquisitionValue=0")
    }

    "include the acquisition costs" in {
      url should include("acquisitionCosts=0")
    }

    "include the improvements" in {
      url should include("improvements=0")
    }
  }

  "The route for the earliest tax year" should {

    "be equal to /capital-gains-calculator/minimum-date" in {
      controllers.routes.TaxRatesAndBandsController.getMinimumDate().url shouldBe "/capital-gains-calculator/minimum-date"
    }
  }

  "The relief model" should {
    "unbind" in {
      val reliefsBinder = OtherReliefsModel.otherReliefsBinder.unbind("key", OtherReliefsModel(0, 0, 0))
      reliefsBinder shouldBe "&otherReliefsFlat=0.0&otherReliefsRebased=0.0&otherReliefsTimeApportioned=0.0"
    }

    "unbind with values" in {
      val reliefsBinder = OtherReliefsModel.otherReliefsBinder.unbind("key", OtherReliefsModel(1.1, 2.2, 3.3))
      reliefsBinder shouldBe "&otherReliefsFlat=1.1&otherReliefsRebased=2.2&otherReliefsTimeApportioned=3.3"
    }

    "bind" in {
      val reliefsBinder = OtherReliefsModel.otherReliefsBinder.bind("key", Map.empty[String, Seq[String]])
      reliefsBinder shouldBe Some(Right(OtherReliefsModel(0.0, 0.0, 0.0)))
    }
  }

  "The Private Residence Relief Model" should {

    "unbind no values defined" in {
      val reliefModel = PrivateResidenceReliefModel(false, None, None)
      val reliefsBinder = PrivateResidenceReliefModel.prrBinder.unbind("key", reliefModel)
      reliefsBinder shouldBe "claimingPRR=false&daysClaimed=0&daysClaimedAfter=0"
    }

    "unbind no one value defined" in {
      val reliefModel = PrivateResidenceReliefModel(true, Some(1.1), None)
      val reliefsBinder = PrivateResidenceReliefModel.prrBinder.unbind("key", reliefModel)
      reliefsBinder shouldBe "claimingPRR=true&daysClaimed=1.1&daysClaimedAfter=0"
    }

    "unbind all values defined" in {
      val reliefModel = PrivateResidenceReliefModel(true, None, Some(2.2))
      val reliefsBinder = PrivateResidenceReliefModel.prrBinder.unbind("key", reliefModel)
      reliefsBinder shouldBe "claimingPRR=true&daysClaimed=0&daysClaimedAfter=2.2"
    }

    "bind with empty seq of config" in {
      val reliefsBinder = PrivateResidenceReliefModel.prrBinder.bind("key", Map.empty[String, Seq[String]])
      reliefsBinder shouldBe None
    }

    "bind with seq of settings" in {
      implicit val booleanBinder = mock[QueryStringBindable[Boolean]]
      implicit val optionDoubleBinder = mock[QueryStringBindable[Option[Double]]]

      when(booleanBinder.bind(any(), any())).thenReturn(Some(Right(true)))
      when(optionDoubleBinder.bind(any(), any())).thenReturn(Some(Right(Some(0.0))))

      val params = Map("param-1" -> Seq("seq1", "value1"))
      val reliefsBinder = PrivateResidenceReliefModel.prrBinder.bind("key", params)
      reliefsBinder shouldBe Some(Right(PrivateResidenceReliefModel(true,Some(0.0),Some(0.0))))
    }
  }

}
