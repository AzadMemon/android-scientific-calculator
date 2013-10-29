package com.thinks.scicalc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalculatorHelper {
	private static final BigDecimal E;
	private static final BigDecimal PI;
	private static String cosInverse;
	private static DecimalFormat df;
	private static char divideChar;
	private static final BigDecimal four;
	private static final MathContext mc;
	private static final BigDecimal one;
	private static String sinInverse;
	private static String squareRootChar;
	private static char subtractChar;
	private static String tanInverse = new String("aTan");
	private static final BigDecimal two;
	private static final BigDecimal zero;

	static {
		sinInverse = new String("aSin");
		cosInverse = new String("aCos");
		divideChar = '�';
		subtractChar = '-';
		squareRootChar = "v";
		mc = new MathContext(15, RoundingMode.UP);
		df = new DecimalFormat("0.############E0");
		zero = new BigDecimal("0");
		one = new BigDecimal("1");
		two = new BigDecimal("2");
		four = new BigDecimal("4");
		PI = new BigDecimal("3.14159265358979323846");
		E = new BigDecimal("2.7182818284590452353602");
	}

	public static boolean dmasSyntaxCheck(StringBuffer paramStringBuffer,
			char paramChar) {
		return (paramChar != '(') && (paramChar != 'x')
				&& (paramChar != divideChar) && (paramChar != '+')
				&& (paramChar != subtractChar) && (paramChar != '-')
				&& (paramChar != '.') && (paramChar != '?')
				&& (paramChar != '^');
	}

	public static StringBuffer evaluateBrackets(StringBuffer paramStringBuffer,
			boolean paramBoolean1, boolean paramBoolean2)
			throws IndexOutOfBoundsException, StringIndexOutOfBoundsException {
		int i = 0;
		if (i >= paramStringBuffer.length())
			return paramStringBuffer;
		if ((paramStringBuffer.indexOf("(") != -1)
				&& (!paramStringBuffer.toString().equals("Error!"))) {
			int j = paramStringBuffer.lastIndexOf("(");
			int k = paramStringBuffer.indexOf(")", j);
			StringBuffer localStringBuffer1 = new StringBuffer(
					paramStringBuffer.substring(j + 1, k));
			if (!localStringBuffer1.toString().equals("Error!")) {
				StringBuffer localStringBuffer2 = evaluateScienceFunction(
						localStringBuffer1, paramBoolean1, paramBoolean2);
				if (!localStringBuffer2.toString().equals("Error!")) {
					StringBuffer localStringBuffer3 = evaluateFactorials(localStringBuffer2);
					if (!localStringBuffer3.toString().equals("Error!")) {
						StringBuffer localStringBuffer4 = evaluateExponents(localStringBuffer3);
						if (!localStringBuffer4.toString().equals("Error!")) {
							StringBuffer localStringBuffer5 = evaluateDMAS(localStringBuffer4);
							if (!localStringBuffer5.toString().equals("Error!")) {
								paramStringBuffer.replace(j, k + 1,
										localStringBuffer5.toString());
								i = 0;
							}
						}
					}
				}
			}
		}
		while (true) {
			i++;
			break;
			paramStringBuffer.replace(0, paramStringBuffer.length(), "Error!");
			continue;
			paramStringBuffer.replace(0, paramStringBuffer.length(), "Error!");
			continue;
			paramStringBuffer.replace(0, paramStringBuffer.length(), "Error!");
			continue;
			paramStringBuffer.replace(0, paramStringBuffer.length(), "Error!");
			continue;
			paramStringBuffer.replace(0, paramStringBuffer.length(), "Error!");
			continue;
			i = paramStringBuffer.length();
		}
	}

	public static StringBuffer evaluateDMAS(StringBuffer paramStringBuffer)
			throws IndexOutOfBoundsException, StringIndexOutOfBoundsException {
		int i = 0;
		int j = 0;
		if (i >= paramStringBuffer.length()) {
			if (j < paramStringBuffer.length())
				break label85;
		}
		label85: do {
			do
				return paramStringBuffer;
			while (paramStringBuffer.toString().equals("Error!"));
			if (paramStringBuffer.charAt(i) == 'x') {
				paramStringBuffer = simplifyDMAS(i, paramStringBuffer, 'x');
				i = 0;
			}
			while (true) {
				i++;
				break;
				if (paramStringBuffer.charAt(i) != divideChar)
					continue;
				paramStringBuffer = simplifyDMAS(i, paramStringBuffer,
						divideChar);
				i = 0;
			}
		} while (paramStringBuffer.toString().equals("Error!"));
		if (paramStringBuffer.charAt(j) == '+')
			paramStringBuffer = simplifyDMAS(j, paramStringBuffer, '+');
		for (int j = 0;; j = 0) {
			do {
				j++;
				break;
			} while ((paramStringBuffer.charAt(j) != '-') || (j == 0)
					|| (paramStringBuffer.charAt(j - 1) == 'E'));
			paramStringBuffer = simplifyDMAS(j, paramStringBuffer, '-');
		}
	}

	public static StringBuffer evaluateExponents(StringBuffer paramStringBuffer)
			throws IndexOutOfBoundsException, StringIndexOutOfBoundsException {
		int i = 0;
		if (i >= paramStringBuffer.length())
			return paramStringBuffer;
		if (paramStringBuffer.toString().equals("Error!"))
			i = paramStringBuffer.length();
		while (true) {
			i++;
			break;
			if (paramStringBuffer.charAt(i) != '^')
				continue;
			paramStringBuffer = simplifyDMAS(i, paramStringBuffer, '^');
			i = 0;
		}
	}

	public static StringBuffer evaluateFactorials(StringBuffer paramStringBuffer)
			throws IndexOutOfBoundsException, StringIndexOutOfBoundsException {
		int i = 0;
		if (i >= paramStringBuffer.length())
			return paramStringBuffer;
		if (paramStringBuffer.toString().equals("Error!"))
			i = paramStringBuffer.length();
		while (true) {
			i++;
			break;
			if (paramStringBuffer.charAt(i) != '!')
				continue;
			paramStringBuffer = simplifyFactorials(i, paramStringBuffer);
			i = 0;
		}
	}

	public static StringBuffer evaluateScienceFunction(
			StringBuffer paramStringBuffer, boolean paramBoolean1,
			boolean paramBoolean2) throws IndexOutOfBoundsException,
			StringIndexOutOfBoundsException {
		int i = 0;
		if (i >= paramStringBuffer.length())
			return paramStringBuffer;
		if (paramStringBuffer.toString().equals("Error!"))
			i = paramStringBuffer.length();
		while (true) {
			i++;
			break;
			if ((i <= -4 + paramStringBuffer.length())
					&& (paramStringBuffer.substring(i, i + 4)
							.equals(tanInverse))) {
				paramStringBuffer = simplifyScienceFunction(i + 4,
						paramStringBuffer, tanInverse, paramBoolean1,
						paramBoolean2);
				i = 0;
				continue;
			}
			if ((i <= -4 + paramStringBuffer.length())
					&& (paramStringBuffer.substring(i, i + 4)
							.equals(cosInverse))) {
				paramStringBuffer = simplifyScienceFunction(i + 4,
						paramStringBuffer, cosInverse, paramBoolean1,
						paramBoolean2);
				i = 0;
				continue;
			}
			if ((i <= -4 + paramStringBuffer.length())
					&& (paramStringBuffer.substring(i, i + 4)
							.equals(sinInverse))) {
				paramStringBuffer = simplifyScienceFunction(i + 4,
						paramStringBuffer, sinInverse, paramBoolean1,
						paramBoolean2);
				i = 0;
				continue;
			}
			if ((i <= -3 + paramStringBuffer.length())
					&& (paramStringBuffer.substring(i, i + 3).equals("Tan"))) {
				paramStringBuffer = simplifyScienceFunction(i + 3,
						paramStringBuffer, "Tan", paramBoolean1, paramBoolean2);
				i = 0;
				continue;
			}
			if ((i <= -3 + paramStringBuffer.length())
					&& (paramStringBuffer.substring(i, i + 3).equals("Cos"))) {
				paramStringBuffer = simplifyScienceFunction(i + 3,
						paramStringBuffer, "Cos", paramBoolean1, paramBoolean2);
				i = 0;
				continue;
			}
			if ((i <= -3 + paramStringBuffer.length())
					&& (paramStringBuffer.substring(i, i + 3).equals("Sin"))) {
				paramStringBuffer = simplifyScienceFunction(i + 3,
						paramStringBuffer, "Sin", paramBoolean1, paramBoolean2);
				i = 0;
				continue;
			}
			if ((i <= -3 + paramStringBuffer.length())
					&& (paramStringBuffer.substring(i, i + 3).equals("Log"))) {
				paramStringBuffer = simplifyScienceFunction(i + 3,
						paramStringBuffer, "Log", false, false);
				i = 0;
				continue;
			}
			if ((i <= -2 + paramStringBuffer.length())
					&& (paramStringBuffer.substring(i, i + 2).equals("Ln"))) {
				paramStringBuffer = simplifyScienceFunction(i + 2,
						paramStringBuffer, "Ln", false, false);
				i = 0;
				continue;
			}
			if ((i > -1 + paramStringBuffer.length())
					|| (!paramStringBuffer.substring(i, i + 1).equals(
							squareRootChar)))
				continue;
			paramStringBuffer = simplifyScienceFunction(i + 1,
					paramStringBuffer, squareRootChar, false, false);
			i = 0;
		}
	}

	public static boolean scienceSyntaxCheck(StringBuffer paramStringBuffer,
			char paramChar) {
		return (paramChar == '(') || (paramChar == 'x')
				|| (paramChar == divideChar) || (paramChar == '+')
				|| (paramChar == subtractChar) || (paramChar == '-')
				|| (paramChar == '^') || (paramChar == '?');
	}

	public static StringBuffer signEvaluate(StringBuffer paramStringBuffer)
			throws IndexOutOfBoundsException {
		int i = 0;
		if (i >= paramStringBuffer.length())
			;
		do
			return paramStringBuffer;
		while (paramStringBuffer.toString().equals("Error!"));
		if ((paramStringBuffer.charAt(i) == '-')
				&& (paramStringBuffer.charAt(i + 1) == '-'))
			paramStringBuffer.replace(i, i + 2, "+");
		for (i = 0;; i = 0) {
			do {
				i++;
				break;
			} while (((paramStringBuffer.charAt(i) != '-') || (paramStringBuffer
					.charAt(i + 1) != '+'))
					&& ((paramStringBuffer.charAt(i) != '+') || (paramStringBuffer
							.charAt(i + 1) != '-')));
			paramStringBuffer.replace(i, i + 2, "-");
		}
	}

	public static StringBuffer simplifyDMAS(int paramInt,
			StringBuffer paramStringBuffer, char paramChar)
			throws IndexOutOfBoundsException, StringIndexOutOfBoundsException {
		StringBuffer localStringBuffer1 = new StringBuffer("");
		StringBuffer localStringBuffer2 = new StringBuffer("");
		int i = 0;
		int j = 0;
		int k = -1 + paramStringBuffer.substring(0, paramInt).length();
		int m;
		BigDecimal localBigDecimal1;
		BigDecimal localBigDecimal2;
		if (k < 0) {
			m = paramInt + 1;
			if (m < paramStringBuffer.length())
				break label321;
			if ((localStringBuffer1.length() == 0)
					|| (localStringBuffer2.length() == 0))
				break label743;
			localBigDecimal1 = new BigDecimal(localStringBuffer1.toString(), mc);
			localBigDecimal2 = new BigDecimal(localStringBuffer2.toString(), mc);
			if (paramChar != '^')
				break label580;
			if ((localBigDecimal1.compareTo(zero) != 0)
					|| (localBigDecimal2.compareTo(zero) > 0))
				break label549;
			paramStringBuffer.replace(0, paramStringBuffer.length(), "Error!");
		}
		while (true) {
			return signEvaluate(paramStringBuffer);
			if ((Character.isDigit(paramStringBuffer.charAt(k)))
					|| (paramStringBuffer.charAt(k) == '.')
					|| (paramStringBuffer.charAt(k) == 'E')
					|| ((k == 0) && (paramStringBuffer.charAt(k) == '-'))
					|| (paramStringBuffer.charAt(k - 1) == 'E')
					|| ((paramStringBuffer.charAt(k) == '-') && ((paramStringBuffer
							.charAt(k - 1) == '(')
							|| (paramStringBuffer.charAt(k - 1) == 'x')
							|| (paramStringBuffer.charAt(k - 1) == divideChar) || (paramStringBuffer
							.charAt(k - 1) == '^'))))
				localStringBuffer1.insert(0, paramStringBuffer.charAt(k));
			while (true) {
				if (k == 0) {
					i = k;
					k = -1;
				}
				k--;
				break;
				i = k + 1;
				k = -1;
			}
			label321: if ((Character.isDigit(paramStringBuffer.charAt(m)))
					|| (paramStringBuffer.charAt(m) == '.')
					|| (paramStringBuffer.charAt(m) == 'E')
					|| ((m == paramInt) && (paramStringBuffer.charAt(m) == '-'))
					|| ((paramStringBuffer.charAt(m) == '-') && ((paramStringBuffer
							.charAt(m - 1) == 'E')
							|| (paramStringBuffer.charAt(m - 1) == '(')
							|| (paramStringBuffer.charAt(m - 1) == 'x')
							|| (paramStringBuffer.charAt(m - 1) == divideChar)
							|| (paramStringBuffer.charAt(m - 1) == '^')
							|| (Character.isLetter(paramStringBuffer
									.charAt(m - 1)))
							|| (paramStringBuffer.charAt(m - 1) == 'v') || (paramStringBuffer
							.charAt(m - 1) == '�'))))
				localStringBuffer2.append(paramStringBuffer.charAt(m));
			while (true) {
				if (m == -1 + paramStringBuffer.length()) {
					j = m + 1;
					m = 1 + paramStringBuffer.length();
				}
				m++;
				break;
				j = m;
				m = 1 + paramStringBuffer.length();
			}
			label549: paramStringBuffer.replace(i, j, df.format(Math.pow(
					localBigDecimal1.doubleValue(),
					localBigDecimal2.doubleValue())));
			continue;
			label580: if (paramChar == 'x') {
				paramStringBuffer.replace(i, j, df.format(localBigDecimal1
						.multiply(localBigDecimal2, mc)));
				continue;
			}
			if (paramChar == divideChar) {
				if (localBigDecimal2.compareTo(zero) == 0) {
					paramStringBuffer.replace(0, paramStringBuffer.length(),
							"Error!");
					continue;
				}
				paramStringBuffer.replace(i, j, df.format(localBigDecimal1
						.divide(localBigDecimal2, mc)));
				continue;
			}
			if (paramChar == '+') {
				paramStringBuffer.replace(i, j,
						df.format(localBigDecimal1.add(localBigDecimal2, mc)));
				continue;
			}
			if (paramChar != '-')
				continue;
			paramStringBuffer.replace(i, j,
					df.format(localBigDecimal1.subtract(localBigDecimal2, mc)));
			continue;
			label743: paramStringBuffer.replace(0, paramStringBuffer.length(),
					"Error!");
		}
	}

	public static StringBuffer simplifyFactorials(int paramInt,
			StringBuffer paramStringBuffer) {
		int i = 0;
		double d1 = 1.0D;
		StringBuffer localStringBuffer = new StringBuffer("");
		int j = -1 + paramStringBuffer.substring(0, paramInt).length();
		int k;
		if (j < 0) {
			double d2 = Double.parseDouble(localStringBuffer.toString());
			if ((d2 != Math.round(d2)) || (d2 < 0.0D) || (d2 > 100.0D))
				break label304;
			k = (int) d2;
			if (k == 0)
				return signEvaluate(signEvaluate(paramStringBuffer.replace(i,
						paramInt + 1, df.format(1.0D))));
		} else {
			if ((Character.isDigit(paramStringBuffer.charAt(j)))
					|| (paramStringBuffer.charAt(j) == '.')
					|| (paramStringBuffer.charAt(j) == 'E')
					|| ((j == 0) && (paramStringBuffer.charAt(j) == '-'))
					|| (paramStringBuffer.charAt(j - 1) == 'E')
					|| ((paramStringBuffer.charAt(j) == '-') && ((paramStringBuffer
							.charAt(j - 1) == '(')
							|| (paramStringBuffer.charAt(j - 1) == 'x')
							|| (paramStringBuffer.charAt(j - 1) == divideChar) || (paramStringBuffer
							.charAt(j - 1) == '^'))))
				localStringBuffer.insert(0, paramStringBuffer.charAt(j));
			while (true) {
				if (j == 0)
					i = j;
				j--;
				break;
				i = j + 1;
				j = -1;
			}
		}
		do {
			d1 *= k;
			k--;
		} while (k > 0);
		return signEvaluate(signEvaluate(paramStringBuffer.replace(i,
				paramInt + 1, df.format(d1))));
		label304: return paramStringBuffer.replace(0,
				paramStringBuffer.length(), "Error!");
	}

	public static StringBuffer simplifyScienceFunction(int paramInt,
			StringBuffer paramStringBuffer, String paramString,
			boolean paramBoolean1, boolean paramBoolean2)
			throws IndexOutOfBoundsException, StringIndexOutOfBoundsException {
		StringBuffer localStringBuffer = new StringBuffer("");
		double d1 = 0.0D;
		int i = 0;
		int j = paramInt;
		BigDecimal localBigDecimal;
		if (j >= paramStringBuffer.length()) {
			localBigDecimal = new BigDecimal(localStringBuffer.toString(), mc);
			if (!paramString.equals(tanInverse))
				break label349;
			if (!Double.isNaN(Math.atan(localBigDecimal.doubleValue())))
				break label336;
			paramStringBuffer.replace(0, paramStringBuffer.length(), "Error!");
			label82: if (paramBoolean1)
				d1 = Math.toDegrees(d1);
			paramStringBuffer.replace(paramInt - 4, i, df.format(d1));
		}
		while (true) {
			return signEvaluate(paramStringBuffer);
			if ((Character.isDigit(paramStringBuffer.charAt(j)))
					|| (paramStringBuffer.charAt(j) == '.')
					|| (paramStringBuffer.charAt(j) == 'E')
					|| ((j == paramInt) && (paramStringBuffer.charAt(j) == '-'))
					|| ((paramStringBuffer.charAt(j) == '-') && ((paramStringBuffer
							.charAt(j - 1) == 'E')
							|| (paramStringBuffer.charAt(j - 1) == '(')
							|| (paramStringBuffer.charAt(j - 1) == 'x')
							|| (paramStringBuffer.charAt(j - 1) == divideChar)
							|| (paramStringBuffer.charAt(j - 1) == '^')
							|| (Character.isLetter(paramStringBuffer
									.charAt(j - 1)))
							|| (paramStringBuffer.charAt(j - 1) == 'v') || (paramStringBuffer
							.charAt(j - 1) == '�'))))
				localStringBuffer.append(paramStringBuffer.charAt(j));
			while (true) {
				if (j == -1 + paramStringBuffer.length())
					i = j + 1;
				j++;
				break;
				i = j;
				j = 1 + paramStringBuffer.length();
			}
			label336: d1 = Math.atan(localBigDecimal.doubleValue());
			break label82;
			label349: if (paramString.equals(cosInverse)) {
				if ((localBigDecimal.compareTo(one) <= 0)
						&& (localBigDecimal.compareTo(one.negate()) >= 0)) {
					double d9 = Math.acos(localBigDecimal.doubleValue());
					if (paramBoolean1)
						d9 = Math.toDegrees(d9);
					paramStringBuffer.replace(paramInt - 4, i, df.format(d9));
					continue;
				}
				paramStringBuffer.replace(0, paramStringBuffer.length(),
						"Error!");
				continue;
			}
			if (paramString.equals(sinInverse)) {
				if ((localBigDecimal.compareTo(one) <= 0)
						&& (localBigDecimal.compareTo(one.negate()) >= 0)) {
					double d8 = Math.asin(localBigDecimal.doubleValue());
					if (paramBoolean1)
						d8 = Math.toDegrees(d8);
					paramStringBuffer.replace(paramInt - 4, i, df.format(d8));
					continue;
				}
				paramStringBuffer.replace(0, paramStringBuffer.length(),
						"Error!");
				continue;
			}
			if (paramString.equals("Tan")) {
				double d7 = Math.tan(localBigDecimal.doubleValue());
				if (paramBoolean1)
					d7 = Math
							.sin(Math.toRadians(localBigDecimal.doubleValue()));
				paramStringBuffer.replace(paramInt - 3, i, df.format(d7));
				continue;
			}
			if (paramString.equals("Sin")) {
				double d6 = Math.sin(localBigDecimal.doubleValue());
				if (paramBoolean1)
					d6 = Math
							.sin(Math.toRadians(localBigDecimal.doubleValue()));
				paramStringBuffer.replace(paramInt - 3, i, df.format(d6));
				continue;
			}
			if (paramString.equals("Cos")) {
				double d5 = Math.cos(localBigDecimal.doubleValue());
				if (paramBoolean1)
					d5 = Math
							.cos(Math.toRadians(localBigDecimal.doubleValue()));
				paramStringBuffer.replace(paramInt - 3, i, df.format(d5));
				continue;
			}
			if (paramString.equals("Log")) {
				if (localBigDecimal.compareTo(zero) == 1) {
					double d4 = Math.log10(localBigDecimal.doubleValue());
					paramStringBuffer.replace(paramInt - 3, i, df.format(d4));
					continue;
				}
				paramStringBuffer.replace(0, paramStringBuffer.length(),
						"Error!");
				continue;
			}
			if (paramString.equals("Ln")) {
				if (localBigDecimal.compareTo(zero) == 1) {
					double d3 = Math.log(localBigDecimal.doubleValue());
					paramStringBuffer.replace(paramInt - 2, i, df.format(d3));
					continue;
				}
				paramStringBuffer.replace(0, paramStringBuffer.length(),
						"Error!");
				continue;
			}
			if (!paramString.equals(squareRootChar))
				continue;
			if (localBigDecimal.compareTo(zero) >= 0) {
				double d2 = Math.sqrt(localBigDecimal.doubleValue());
				paramStringBuffer.replace(paramInt - 1, i, df.format(d2));
				continue;
			}
			paramStringBuffer.replace(0, paramStringBuffer.length(), "Error!");
		}
	}

	public static boolean specialScienceSyntaxCheck(
			StringBuffer paramStringBuffer, char paramChar) {
		return ((paramChar == ')') || (Character.isDigit(paramChar))
				|| (paramChar == '?') || (paramChar == 'e') || ((paramStringBuffer
				.length() >= 3) && (paramStringBuffer.substring(-3
				+ paramStringBuffer.length(), paramStringBuffer.length())
					.equals("ANS"))))
				&& (paramChar != '?');
	}
}