class Solution {
    public String oddString(String[] words) {
        String d1 = getDiff(words[0]);
        String d2 = getDiff(words[1]);
        String d3 = getDiff(words[2]);

        String common;

        if (d1.equals(d2)) {
            common = d1;
        } else if (d1.equals(d3)) {
            common = d1;
            if (!d2.equals(common)) {
                return words[1];
            }
        } else {
            common = d2;
            return words[0];
        }

        for (int i = 2; i < words.length; i++) {
            if (!getDiff(words[i]).equals(common)) {
                return words[i];
            }
        }

        return words[0];
    }

    private String getDiff(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < word.length(); i++) {
            sb.append((word.charAt(i) - word.charAt(i - 1))).append(",");
        }

        return sb.toString();
    }
}