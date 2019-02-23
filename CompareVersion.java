public class CompareVersion {
    private static int compareVersion(String version1, String version2) {
        String[] lev1 = version1.split("\\.");
        String[] lev2 = version2.split("\\.");

        int levLength = Math.max(lev1.length,lev2.length);

        for(int i = 0; i < levLength; i++){
            Integer v1 = i < lev1.length ? Integer.parseInt(lev1[i]) : 0;
            Integer v2 = i < lev2.length ? Integer.parseInt(lev2[i]) : 0;

            int compare = v1.compareTo(v2);

            if(compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String firstString = "7.5.2.4";
        String secondString = "7.5.3";

        int result = compareVersion(firstString, secondString);
        System.out.println(result);
    }
}
