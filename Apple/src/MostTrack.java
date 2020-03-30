/*
Imagine a list of track plays logged by Apple music users across the world.

Given a comma-separated ordered list of these events, of the form:

 user_id, track_id, timestamp
Write a program to compute the most common three-play sequence, and the
number of times that sequence was played on Apple music.
three-play sequence: means which 3 tracks were played in order(one after another) The count of the sequence(not the track itself)

 */

public class MostTrack {

    public static void main(String[] args) {
        String[] input = new String[] {
                "daniel,ShapeOfYou,1519753867",
                "daniel,Perfect,1519753868",
                "martin,ShapeOfYou,1519753869",
                "daniel,Thunder,1519753870",
                "martin,ShapeOfYou,1519753871",
                "martin,Despacito,1519753872",
                "martin,ShapeOfYou,1519753873",
                "martin,Perfect,1519753874",
                "daniel,Despacito,1519753875",
                "martin,Thunder,1519753875"};
        String mostCommon = mostCommonSongs(input, "daniel");
        System.out.println(mostCommon);
    }

    public static String mostCommonSongs(String[] data, String name) {
        String res = "";
        

        return res;
    }

}
