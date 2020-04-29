/*
 * Copyright 2020 Nikolay Papakha
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
package com.github.papahigh.phonetic.buffer;


/**
 * Represents input buffer with stemming analysis and fixed max-length limit.
 */
public class StemmedInputBuffer extends InputBuffer {

    private int stemmedLength;
    private final int maxLength;

    public StemmedInputBuffer(char[] buffer, int bufferLength, int stemmedLength, int maxLength) {
        super(buffer, bufferLength);
        this.stemmedLength = stemmedLength;
        this.maxLength = maxLength;
    }

    @Override
    public void dropChar() {
        stemmedLength = Math.max(stemmedLength - 1, 0);
    }

    @Override
    public void dropChars(int n) {
        stemmedLength = Math.max(stemmedLength - n, 0);
    }

    @Override
    public void dropChars2() {
        stemmedLength = Math.max(stemmedLength - 2, 0);
    }

    @Override
    public int getLimit() {
        return Math.min(stemmedLength, maxLength);
    }
}
