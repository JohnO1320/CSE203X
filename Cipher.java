
public class Cipher {
	public static void main(String[] args) { 		
		String s = "Lb, fb unir lbh orra cynlvat gung arj Zrfbcrgf tnzr? Gubfr arj Zrtnybalpuvqnr naq Oenqlcbqvqnr gurl nqqrq ner cerggl pbby. Npghnyyl, V jbhyq tb nf sne nf fnlvat gung vg vf abj zl yvsr'f qrnerfg nzovgvba gb bognva n \"Vasyngnoyr Fybgu Zbafgre\"!";
		for (int i = 0; i < 26; i++) {
			String decrypt = "";
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if ('A' <= c && c <= 'Z') {
					c = (char) (((c + i - 'A') % 26) + 'A');
					decrypt += c;
				} else if ('a' <= c && c <= 'z') {
					c = (char) (((c + i - 'a') % 26) + 'a');
					decrypt += c;
				} else {
					decrypt += c;
				}
			}
			System.out.println(decrypt);
		}
	}
}
