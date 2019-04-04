/*******************************************************************************
 * Copyright 2015 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package de.tomgrill.gdxtesting.examples;

import com.group.abcdraw.model.Position;
import com.group.abcdraw.utils.Utils;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TransformUnitTest {

	static float screenMaxX = 720f;
	static float screenMaxY = 1280f;
	static float textureMaxX = 1440f;
	static float textureMaxY = 2960f;
	static float ratioScreen = 720f/1280f;
	static float textureMaxYConstrained = textureMaxY * ratioScreen;

	@Test
	public void positionMin() {
		Position toPos = Utils.toTexture(0,0, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(0, toPos.getX(), 0.0001);
		assertEquals(0, toPos.getY(), 0.0001);
	}
	@Test
	public void positionXMax() {
		Position toPos = Utils.toTexture(screenMaxX,0, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(textureMaxX, toPos.getX(), 0.0001);
		assertEquals(0, toPos.getY(), 0.0001);
	}
	@Test
	public void positionXMiddle() {
		Position toPos = Utils.toTexture(screenMaxX/2,0, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(textureMaxX/2, toPos.getX(), 0.0001);
		assertEquals(0, toPos.getY(), 0.0001);
	}

	@Test
	public void positionYMax() {
		Position toPos = Utils.toTexture(0,screenMaxY, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(0, toPos.getX(), 0.0001);
		assertEquals(textureMaxYConstrained, toPos.getY(), 0.0001);
	}

	@Test
	public void positionYMiddle() {
		Position toPos = Utils.toTexture(0, screenMaxY/2f, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(0, toPos.getX(), 0.0001);
		assertEquals(textureMaxYConstrained /2f , toPos.getY(), 0.0001);
	}

	@Test
	public void positionXYMiddle() {
		Position toPos = Utils.toTexture(screenMaxX/2f, screenMaxY/2f, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(textureMaxX/2f, toPos.getX(), 0.0001);
		assertEquals(textureMaxYConstrained /2f , toPos.getY(), 0.0001);
	}

	@Test
	public void position2ScreeenMin() {
		Position toPos = Utils.toScreen(0,0, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(0, toPos.getX(), 0.0001);
		assertEquals(0, toPos.getY(), 0.0001);
	}

	@Test
	public void position2ScreenXMax() {
		Position toPos = Utils.toScreen(textureMaxX,0, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(screenMaxX, toPos.getX(), 0.0001);
		assertEquals(0, toPos.getY(), 0.0001);
	}

	@Test
	public void position2ScreenXMaxMiddle() {
		Position toPos = Utils.toScreen(textureMaxX / 2f,0, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(screenMaxX /2f, toPos.getX(), 0.0001);
		assertEquals(0, toPos.getY(), 0.0001);
	}

	@Test
	public void position2ScreenYMax() {
		Position toPos = Utils.toScreen(0,textureMaxY, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(0, toPos.getX(), 0.0001);
		assertEquals(screenMaxY, toPos.getY(), 0.0001);
	}

	@Test
	public void position2ScreenYMaxConstrained() {
		Position toPos = Utils.toScreen(0,textureMaxYConstrained, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(0, toPos.getX(), 0.0001);
		assertEquals(screenMaxY, toPos.getY(), 0.0001);
	}

	@Test
	public void position2ScreenYMaxConstrainedHalf() {
		Position toPos = Utils.toScreen(0,textureMaxYConstrained/2f, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(0, toPos.getX(), 0.0001);
		assertEquals(screenMaxY/2f, toPos.getY(), 0.0001);
	}

	@Test
	public void position2ScreenYMaxConstrainedHalfXY() {
		Position toPos = Utils.toScreen(textureMaxX/2f,textureMaxYConstrained/2f, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
		assertEquals(screenMaxX/2f, toPos.getX(), 0.0001);
		assertEquals(screenMaxY/2f, toPos.getY(), 0.0001);
	}

	@Test
	public void randomPointsfromScreenBackToScreen() {
		for (int i = 0; i < 100; i++) {
			Position screen = new Position((float) (Math.random() * screenMaxX), (float)(Math.random() * screenMaxY) );
			Position texture = Utils.toTexture(screen.getX(), screen.getY(), screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
			Position screenNew = Utils.toScreen(texture, screenMaxX, screenMaxY,  textureMaxX, textureMaxY);
			assertEquals(screen.getX(), screenNew.getX(), 0.001);
			assertEquals(screen.getY(), screenNew.getY(), 0.001);
		}
	}
}
