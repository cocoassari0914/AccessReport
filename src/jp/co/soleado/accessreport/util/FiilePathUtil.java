package jp.co.soleado.accessreport.util;

public final class FiilePathUtil {
    /**
     * データファイル保存ディレクトリの取得
     * @return
     */
    public static String getDataFilePath() {
        String current = System.getProperty("user.dir");
        return String.format("%s\\%s", current, "data");
    }
}
