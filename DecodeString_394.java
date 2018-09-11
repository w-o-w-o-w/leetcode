
public class DecodeString_394 {

	public static void main(String ar[]) {
		String s = "";
		decodeString(s);
	}

	public static String decodeString(String s) {
		char[] arr = s.toCharArray();

		Data d = makeSubStr(1, 0, arr);
		return d.result;
	}

	public static Data makeSubStr(int num, int offset, char[] arr) {
		String str = "";
		int cnt = 0;
		String n = "";
		for (int i = offset; i < arr.length; ++i) {
			cnt++;
			if (arr[i] == '[') {
				Data data = makeSubStr(Integer.parseInt(n), i + 1, arr);
				i += data.offset;
				cnt += data.offset;
				str += data.result;
				n = "";
			} else if (isNum(arr[i])) {
				n += arr[i];
				continue;
			} else if (arr[i] == ']') {
				break;
			} else {
				str += arr[i];
			}
		}
		String result = "";
		for (int i = 0; i < num; ++i) {
			result += str;
		}
		Data d = new Data();
		d.offset = cnt;
		d.result = result;
		// System.out.println(d.result);
		return d;
	}

	public static boolean isNum(char a) {
		if (a >= '0' && a <= '9') {
			return true;
		}
		return false;
	}
}

class Data {
	int offset;
	String result;
}
