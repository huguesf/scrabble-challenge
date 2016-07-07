/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferland.hugues.challenge.scabblesets;

import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hugues
 */
public class BagTest {

    Bag bag;

    public BagTest() {
    }

    @Before
    public void setUp() {
        bag = new Bag();
    }

    @Test
    public void initialBagForA() {
        assertThat(bag.count('A'), is(9));
        assertThat(bag.count('B'), is(2));
    }

    @Test
    public void countAfterRemoveSingleCharacter() {
        bag.remove('A');
        assertThat(bag.count('A'), is(8));
    }

    @Test(expected = IllegalStateException.class)
    public void removingMoreThanAvailableMustFail() {
        bag.remove('Z');
        bag.remove('Z');
    }
}
