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

package common

import org.joda.time.{DateTime, Days}

object Date {

  def daysBetween(start: String, end: String): Double = {
    Days.daysBetween(DateTime.parse(start), DateTime.parse(end)).getDays + 1
  }

  def daysBetween(start: DateTime, end: DateTime): Double = {
    Days.daysBetween(start, end).getDays + 1
  }
}