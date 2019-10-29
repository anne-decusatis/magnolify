/*
 * Copyright 2019 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package magnolify.shared

object Converter {
  trait Record[T, Reader, Writer] extends Serializable {
    protected def empty: Writer
    def from(r: Reader): T
    def to(t: T): Writer
  }

  trait Field[V, Reader, Writer] extends Record[V, Reader, Writer] {
    def get(r: Reader, k: String): V
    def put(r: Writer, k: String, v: V): Writer
  }
}
