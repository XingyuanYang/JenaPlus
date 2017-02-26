package com.mood.jenaPlus;
import android.location.Location;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by Carlo on 2017-02-26.
 */


public class ParticipantTest{

    /**
     * Test has user name.
     *
     * @throws Exception the exception
     */
    @Test
    public void testHasUserName() throws Exception {
        String existingUserName = "testUserName";
        Participant newParticipant1 = new Participant(existingUserName);
        assertTrue(newParticipant1.hasUserName(existingUserName));
    }

    /**
     * Test get user name.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetUserName() throws Exception {
        String userName = "testUserName";
        Participant newParticipant = new Participant(userName);
        assertEquals(newParticipant.getUserName(),userName);
    }

    /**
     * Test add new mood event.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddNewMoodEvent() throws Exception {
        MoodIcon m = new MoodIcon();
        String userName = "testUserName";
        String text = "I'm happy!";
        Boolean addLocation = false;
        Location location = null;
        String id = m.getMood(8);
        String social = null;
        String photo = null;
        String color = m.getMood(8);

        Participant newParticipant = new Participant(userName);
        newParticipant.addNewMood(text,addLocation,location,id,social,photo,color);
        MoodList moodList = newParticipant.getUserMoodList();

        //Checking if the mood was added
        assertFalse(moodList.userIsEmpty());
    }

    @Test
    public void testGetUserMoodList() throws Exception {
        MoodIcon m = new MoodIcon();
        String userName = "testUserName";
        String text = "I'm happy!";
        Boolean addLocation = false;
        Location location = null;
        String id = m.getMood(8);
        String social = null;
        String photo = null;
        String color = m.getMood(8);

        MoodIcon m2 = new MoodIcon();
        String text2 = "I'm Disgusted";
        Boolean addLocation2 = false;
        Location location2 = null;
        String id2 = m2.getMood(3);
        String social2 = null;
        String photo2 = null;
        String color2 = m2.getMood(3);

        Participant newParticipant = new Participant(userName);
        newParticipant.addNewMood(text,addLocation,location,id,social,photo,color);
        newParticipant.addNewMood(text2,addLocation2,location2,id2,social2,photo2,color2);

        MoodList userList = newParticipant.getUserMoodList();
        Mood mood0 = userList.getUserMood(0);
        Mood mood1 = userList.getUserMood(1);

        assertEquals(mood0.getText(),text);
        assertEquals(mood1.getText(),text2);
    }

    @Test
    public void testGetFollowingMoodList() throws Exception {

    }
}
