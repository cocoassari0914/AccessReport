package jp.co.soleado.accessreport.util;

public final class FiilePathUtil {
    /**
     * �f�[�^�t�@�C���ۑ��f�B���N�g���̎擾
     * @return
     */
    public static String getDataFilePath() {
        String current = System.getProperty("user.dir");
        return String.format("%s\\%s", current, "data");
    }
}
