import java.util.*;

public class FavoriteGenre {

    public static void main(String[] args) {
        Map<String, List<String>> userSongs = setupSong();
        Map<String, List<String>> songGenres = setupGenre();

        Map<String, List<String>> result = favGenre(userSongs, songGenres);


        for(String key : result.keySet()) {
            System.out.println(result.get(key).toString());
        }


    }

    public static Map<String, List<String>>  favGenre(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        HashMap<String, List<String>> result = new HashMap<>();

        for(String user : userSongs.keySet()) {
            result.put(user, new ArrayList<>());
            HashMap<String, Integer> count = new HashMap<>();
            int max = 0;
            for(String song : userSongs.get(user)) {
                String genre = findGenre(song, songGenres);
                if(genre.equals("")) continue;
                if(!count.containsKey(genre)) {
                    count.put(genre, 0);
                }
                count.put(genre, count.get(genre) + 1);
                max = Math.max(max, count.get(genre));
            }
            for(String genre : count.keySet()) {
                if(count.get(genre) == max) {
                    result.get(user).add(genre);
                }
            }
        }

        return result;
    }

    private static String findGenre(String song, Map<String, List<String>> songGenres) {
        for(String genre : songGenres.keySet()) {
            if(songGenres.get(genre).contains(song)) {
                return genre;
            }
        }
        return "";
    }

    private static Map<String, List<String>> setupSong() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> songs = new ArrayList<String>() {{
            addAll(Arrays.asList("song1", "song2"));
        }};
        List<String> songs2 = new ArrayList<String>() {{
            addAll(Arrays.asList("song5", "song6"));
        }};
        map.put("David", songs);
        map.put("Emma", songs2);

        return map;
    }

    private static Map<String, List<String>> setupGenre() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Rock", new ArrayList<String>() {{
            addAll(Arrays.asList("song1", "song3"));
        }});
        map.put("Dubstep", new ArrayList<String>() {{
            addAll(Arrays.asList("song7"));
        }});
        map.put("Techno", new ArrayList<String>() {{
            addAll(Arrays.asList("song2", "song4"));
        }});
        map.put("Pop", new ArrayList<String>() {{
            addAll(Arrays.asList("song5", "song6"));
        }});
        map.put("Jazz", new ArrayList<String>() {{
            addAll(Arrays.asList("song8", "song9"));
        }});

        return map;
    }
}
