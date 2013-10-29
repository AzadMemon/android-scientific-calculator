package com.thinks.scicalc;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends Activity {
	private static final BigDecimal E;
	private static final BigDecimal PI;
	private static final DecimalFormat df = new DecimalFormat("0.#########E0");
	private static final BigDecimal ten;
	private boolean allNumbersForNegSign = false;
	private String ans = new String("");
	private Button button0;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button buttonAdd;
	private Button buttonAnswer;
	private Button buttonBracketClose;
	private Button buttonBracketOpen;
	private Button buttonClear;
	private Button buttonCos;
	private Button buttonCosInverse;
	private Button buttonDR;
	private Button buttonDecimal;
	private Button buttonDelete;
	private Button buttonDivide;
	private Button buttonE;
	private Button buttonEqual;
	private Button buttonExponent;
	private Button buttonFactorial;
	private Button buttonInverse;
	private Button buttonLn;
	private Button buttonLnInverse;
	private Button buttonLog;
	private Button buttonLogInverse;
	private Button buttonMultiply;
	private Button buttonNegative;
	private Button buttonPI;
	private Button buttonSin;
	private Button buttonSinInverse;
	private Button buttonSquareRoot;
	private Button buttonSquared;
	private Button buttonSubtract;
	private Button buttonTan;
	private Button buttonTanInverse;
	private String cosInverse = "aCos";
	private Spanned cosInverseText = Html.fromHtml("Cos<sup>-1</sup>");
	private boolean decimalPressed = false;
	private boolean deg = true;
	private String divide = new String("�");
	private char divideChar = '�';
	private boolean equalPressed = false;
	private StringBuffer equation = new StringBuffer("");
	private Spanned exponentText = Html.fromHtml("y<sup>x</sup>");
	private Spanned inverseText = Html.fromHtml("x<sup>-1</sup>");
	private char lastChar;
	private String lnInverse = "e^x";
	private Spanned lnInverseText = Html.fromHtml("e<sup>x</sup>");
	private String logInverse = "10^x";
	private Spanned logInverseText = Html.fromHtml("10<sup>x</sup>");
	private String negative = new String("(-)");
	private boolean negativePressed = false;
	private int numberOfClosedBrackets = 0;
	private int numberOfOpenBrackets = 0;
	private String piSymbol = new String("?");
	private boolean rad = false;
	private String sinInverse = "aSin";
	private Spanned sinInverseText = Html.fromHtml("Sin<sup>-1</sup>");
	private String squareRoot = new String("vx");
	private char squareRootChar = 'v';
	private String squared = new String("x�");
	private Spanned squaredText = Html.fromHtml("x<sup>2</sup");
	private String subtract = new String("-");
	private char subtractChar = '-';
	private String tanInverse = "aTan";
	private Spanned tanInverseText = Html.fromHtml("Tan<sup>-1</sup>");
	private EditText textField;

	static {
		PI = new BigDecimal("3.14159265358979323846264338327950288419");
		E = new BigDecimal("2.71828182845904523536028747135266249775");
		ten = new BigDecimal("10");
	}

	public void ButtonHandler(String paramString)
	{
    this.equation.replace(0, this.equation.length(), this.textField.getText().toString());
    if (this.equation.toString().equals("Error!"))
    {
      this.equation.replace(0, this.equation.length(), "");
      this.textField.setText("");
      this.numberOfOpenBrackets = 0;
      this.numberOfClosedBrackets = 0;
      this.equalPressed = false;
      this.decimalPressed = false;
      this.allNumbersForNegSign = false;
      this.negativePressed = false;
      this.ans = "";
    }
    if (((paramString.equals("x")) || (paramString.equals(this.divide)) || (paramString.equals("+")) || (paramString.equals("^")) || (paramString.equals(this.subtract))) && (this.equalPressed) && (this.ans.length() != 0))
    {
      this.equation.replace(0, this.equation.length(), "ANS");
      this.textField.setText(this.equation.toString());
      this.equalPressed = false;
      if (this.equation.length() != 0)
        break label646;
      this.lastChar = '?';
      label230: if ((this.decimalPressed) || (!paramString.equals(".")) || ((this.lastChar != '?') && (this.lastChar != '(') && (this.lastChar != '-') && (this.lastChar != 'x') && (this.lastChar != '+') && (this.lastChar != this.divide.toCharArray()[0]) && (this.lastChar != this.subtract.toCharArray()[0]) && (this.lastChar != '^')))
        break label669;
      this.equation.append("0.");
      this.textField.setText(this.equation.toString());
      this.decimalPressed = true;
      label363: if ((this.negativePressed) || (!paramString.equals(this.negative)))
        break label927;
      if ((this.lastChar != '?') && (this.lastChar != '^') && (this.lastChar != '(') && (this.lastChar != 'x') && (this.lastChar != this.divideChar))
        break label765;
      this.equation.append("-");
      this.textField.setText(this.equation.toString());
      this.negativePressed = true;
      label458: if ((!this.negativePressed) || (paramString.equals("(")) || (Character.isDigit(paramString.charAt(0))) || (Character.isLetter(paramString.charAt(0))))
      {
        if ((!paramString.equals("ANS")) || (this.ans == ""))
          break label935;
        this.equation.append("ANS");
        this.textField.setText(this.equation.toString());
      }
    }
    label646: label669: label765: 
    do
      while (true)
      {
        this.textField.setSelection(this.textField.getText().length());
        return;
        if ((paramString.equals("=")) || (paramString.equals(")")) || (paramString.equals("Rad")) || (paramString.equals("Deg")) || (!this.equalPressed))
          break;
        this.equation.delete(0, this.equation.length());
        this.textField.setText(this.equation.toString());
        this.equalPressed = false;
        break;
        this.lastChar = this.equation.charAt(-1 + this.equation.length());
        break label230;
        if ((!this.decimalPressed) && (paramString.equals(".")) && (Character.isDigit(this.lastChar)))
        {
          this.equation.append(".");
          this.textField.setText(this.equation.toString());
          this.decimalPressed = true;
          break label363;
        }
        if ((!this.decimalPressed) || (Character.isDigit(paramString.charAt(0))) || (paramString.equals(".")))
          break label363;
        this.decimalPressed = false;
        break label363;
        int i2 = 0;
        if (i2 >= this.equation.length())
          if (this.allNumbersForNegSign)
          {
            if (Double.parseDouble(this.equation.toString()) != 0.0D)
              break label881;
            this.allNumbersForNegSign = false;
          }
        while (true)
        {
          this.textField.setText(this.equation.toString());
          break;
          if ((Character.isDigit(this.equation.charAt(i2))) || (this.equation.charAt(i2) == '.'))
            this.allNumbersForNegSign = true;
          while (true)
          {
            i2++;
            break;
            this.allNumbersForNegSign = false;
            i2 = this.equation.length();
          }
          if (this.equation.charAt(0) == '-')
          {
            this.equation.deleteCharAt(0);
            continue;
          }
          if (!this.allNumbersForNegSign)
            continue;
          this.equation.insert(0, '-');
        }
        this.negativePressed = false;
        break label458;
        if ((Character.isDigit(paramString.charAt(0))) && (paramString.length() == 1) && (this.lastChar != '?') && (this.lastChar != 'e'))
        {
          if ((paramString.charAt(0) == '0') && (this.lastChar == '-'))
            continue;
          this.equation.append(paramString.charAt(0));
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (paramString.equals("("))
        {
          this.equation.append("(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals(")"))
        {
          if ((this.lastChar == '(') || (this.lastChar == 'x') || (this.lastChar == this.divideChar) || (this.lastChar == '+') || (this.lastChar == this.subtractChar) || (this.lastChar == '-') || (this.lastChar == '.') || (this.lastChar == '?') || (this.numberOfOpenBrackets <= this.numberOfClosedBrackets))
            continue;
          this.equation.append(")");
          this.textField.setText(this.equation.toString());
          this.numberOfClosedBrackets = (1 + this.numberOfClosedBrackets);
          continue;
        }
        if ((paramString.equals("Deg")) || (paramString.equals("Rad")))
        {
          if (this.deg)
          {
            this.deg = false;
            this.rad = true;
            this.buttonDR.setText("Rad");
            continue;
          }
          if (!this.rad)
            continue;
          this.rad = false;
          this.deg = true;
          this.buttonDR.setText("Deg");
          continue;
        }
        if (paramString.equals("Sin"))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("Sin(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals("Cos"))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("Cos(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals("Tan"))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("Tan(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals(this.sinInverse))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append(this.sinInverse + "(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals(this.cosInverse))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append(this.cosInverse + "(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals(this.tanInverse))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append(this.tanInverse + "(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals("Log"))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("Log(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals("Ln"))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("Ln(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals("1/x"))
        {
          if (!CalculatorHelper.specialScienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("^(-1)");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          this.numberOfClosedBrackets = (1 + this.numberOfClosedBrackets);
          continue;
        }
        if (paramString.equals(this.piSymbol))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append(this.piSymbol);
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (paramString.equals("e"))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append('e');
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (paramString.equals(this.squareRoot))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append(this.squareRootChar + "(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals(this.squared))
        {
          if (!CalculatorHelper.specialScienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("^(2)");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          this.numberOfClosedBrackets = (1 + this.numberOfClosedBrackets);
          continue;
        }
        if (paramString.equals(this.logInverse))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("10^(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals(this.lnInverse))
        {
          if (!CalculatorHelper.scienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("e^(");
          this.textField.setText(this.equation.toString());
          this.numberOfOpenBrackets = (1 + this.numberOfOpenBrackets);
          continue;
        }
        if (paramString.equals("^"))
        {
          if (!CalculatorHelper.specialScienceSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("^");
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (paramString.equals("n!"))
        {
          if ((!Character.isDigit(this.lastChar)) && (this.lastChar != ')'))
            continue;
          this.equation.append('!');
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (paramString.equals(this.divide))
        {
          if (!CalculatorHelper.dmasSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append(this.divideChar);
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (paramString.equals("x"))
        {
          if (!CalculatorHelper.dmasSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("x");
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (paramString.equals(this.subtract))
        {
          if (!CalculatorHelper.dmasSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append(this.subtractChar);
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (paramString.equals("+"))
        {
          if (!CalculatorHelper.dmasSyntaxCheck(this.equation, this.lastChar))
            continue;
          this.equation.append("+");
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (paramString.equals("DEL"))
        {
          if (this.lastChar == '?')
            continue;
          if ((this.equation.length() >= 6) && (this.equation.substring(-6 + this.equation.length()).equals("Error!")))
          {
            this.equation.delete(-6 + this.equation.length(), this.equation.length());
            this.textField.setText(this.equation.toString());
            continue;
          }
          if ((this.equation.length() >= 5) && ((this.equation.substring(-5 + this.equation.length()).equals("aSin(")) || (this.equation.substring(-5 + this.equation.length()).equals("aCos(")) || (this.equation.substring(-5 + this.equation.length()).equals("aTan("))))
          {
            this.equation.delete(-5 + this.equation.length(), this.equation.length());
            this.textField.setText(this.equation.toString());
            this.numberOfOpenBrackets = (-1 + this.numberOfOpenBrackets);
            continue;
          }
          if ((this.equation.length() >= 4) && ((this.equation.substring(-4 + this.equation.length()).equals("Log(")) || (this.equation.substring(-4 + this.equation.length()).equals("Sin(")) || (this.equation.substring(-4 + this.equation.length()).equals("Cos(")) || (this.equation.substring(-4 + this.equation.length()).equals("Tan(")) || (this.equation.substring(-4 + this.equation.length()).equals("10^("))))
          {
            this.equation.delete(-4 + this.equation.length(), this.equation.length());
            this.textField.setText(this.equation.toString());
            this.numberOfOpenBrackets = (-1 + this.numberOfOpenBrackets);
            continue;
          }
          if ((this.equation.length() >= 4) && (this.equation.substring(-4 + this.equation.length()).equals("^(2)")))
          {
            this.equation.delete(-4 + this.equation.length(), this.equation.length());
            this.textField.setText(this.equation.toString());
            this.numberOfOpenBrackets = (-1 + this.numberOfOpenBrackets);
            this.numberOfClosedBrackets = (-1 + this.numberOfClosedBrackets);
            continue;
          }
          if ((this.equation.length() >= 3) && ((this.equation.substring(-3 + this.equation.length()).equals("Ln(")) || (this.equation.substring(-3 + this.equation.length()).equals("e^(")) || (this.equation.substring(-3 + this.equation.length()).equals("1/(")) || (this.equation.substring(-3 + this.equation.length()).equals("ANS"))))
          {
            this.equation.delete(-3 + this.equation.length(), this.equation.length());
            this.textField.setText(this.equation.toString());
            this.numberOfOpenBrackets = (-1 + this.numberOfOpenBrackets);
            continue;
          }
          if ((this.equation.length() >= 2) && (this.equation.substring(-2 + this.equation.length()).equals("v(")))
          {
            this.equation.delete(-2 + this.equation.length(), this.equation.length());
            this.textField.setText(this.equation.toString());
            this.numberOfOpenBrackets = (-1 + this.numberOfOpenBrackets);
            continue;
          }
          if (this.lastChar == '(')
          {
            this.equation.deleteCharAt(-1 + this.equation.length());
            this.textField.setText(this.equation.toString());
            this.numberOfOpenBrackets = (-1 + this.numberOfOpenBrackets);
            continue;
          }
          if (this.lastChar == ')')
          {
            this.equation.deleteCharAt(-1 + this.equation.length());
            this.textField.setText(this.equation.toString());
            this.numberOfClosedBrackets = (-1 + this.numberOfClosedBrackets);
            continue;
          }
          if (this.lastChar == '-')
          {
            this.equation.deleteCharAt(-1 + this.equation.length());
            this.textField.setText(this.equation.toString());
            this.negativePressed = false;
            continue;
          }
          if ((this.equation.length() >= 2) && (this.equation.substring(-2 + this.equation.length()).equals("0.")))
          {
            this.equation.delete(-2 + this.equation.length(), this.equation.length());
            this.textField.setText(this.equation.toString());
            this.decimalPressed = false;
            continue;
          }
          if (this.lastChar == '.')
          {
            this.equation.deleteCharAt(-1 + this.equation.length());
            this.textField.setText(this.equation.toString());
            this.decimalPressed = false;
            continue;
          }
          this.equation.deleteCharAt(-1 + this.equation.length());
          this.textField.setText(this.equation.toString());
          continue;
        }
        if (!paramString.equals("CE"))
          break label3784;
        this.equation.delete(0, this.equation.length());
        this.textField.setText("");
        this.numberOfOpenBrackets = 0;
        this.numberOfClosedBrackets = 0;
        this.negativePressed = false;
      }
    while ((!paramString.equals("=")) || ((this.lastChar != ')') && (!Character.isDigit(this.lastChar)) && (this.lastChar != '?') && ((this.equation.length() < 3) || (!this.equation.substring(-3 + this.equation.length()).equals("ANS"))) && (this.lastChar != '!') && (this.lastChar != 'e')));
    label881: int i1;
    label927: label935: label3784: int i;
    label3903: label3913: int j;
    label3928: int k;
    label3943: int m;
    if (this.numberOfOpenBrackets != this.numberOfClosedBrackets)
    {
      int n = this.numberOfOpenBrackets - this.numberOfClosedBrackets;
      i1 = 0;
      if (i1 < n);
    }
    else
    {
      i = 0;
      if (i < this.equation.length())
        break label4366;
      j = 0;
      if (j < this.equation.length())
        break label4410;
      k = 0;
      if (k < this.equation.length())
        break label4453;
      m = 0;
      label3958: if (m < this.equation.length())
        break label4596;
      this.equation.replace(0, this.equation.length(), this.equation.toString().replaceAll("ANS", this.ans));
      this.equation = CalculatorHelper.signEvaluate(this.equation);
      if (this.numberOfOpenBrackets != 0)
        this.equation = CalculatorHelper.evaluateBrackets(this.equation, this.deg, this.rad);
      this.equation = CalculatorHelper.evaluateScienceFunction(this.equation, this.deg, this.rad);
      this.equation = CalculatorHelper.evaluateFactorials(this.equation);
      this.equation = CalculatorHelper.evaluateExponents(this.equation);
      this.equation = CalculatorHelper.evaluateDMAS(this.equation);
      if ((this.equation.toString().equalsIgnoreCase("NaN")) || (this.equation.toString().equalsIgnoreCase("Infinity")) || (this.equation.toString().equalsIgnoreCase("-Infinity")))
        this.equation.replace(0, this.equation.length(), "Error!");
      if (!this.equation.toString().equals("Error!"))
        this.equation.replace(0, this.equation.length(), df.format(new BigDecimal(this.equation.toString())));
      if (!this.equation.substring(1 + this.equation.indexOf("E"), this.equation.length()).equals("0"))
        break label4648;
      this.equation.deleteCharAt(-1 + this.equation.length());
      this.equation.deleteCharAt(-1 + this.equation.length());
    }
    while (true)
    {
      this.textField.setText(this.equation.toString());
      if (!this.equation.toString().equals("Error!"))
        this.ans = this.equation.toString();
      this.numberOfOpenBrackets = 0;
      this.numberOfClosedBrackets = 0;
      this.equalPressed = true;
      break;
      this.equation.append(")");
      this.numberOfClosedBrackets = (1 + this.numberOfClosedBrackets);
      i1++;
      break label3903;
      label4366: if (this.equation.charAt(i) == '?')
      {
        this.equation.replace(i, i + 1, PI.toString());
        i = 0;
      }
      i++;
      break label3913;
      label4410: if (this.equation.charAt(j) == 'e')
      {
        this.equation.replace(j, j + 1, E.toString());
        j = 0;
      }
      j++;
      break label3928;
      label4453: if ((k != -1 + this.equation.length()) && (((this.equation.charAt(k) == ')') && (this.equation.charAt(k + 1) == '(')) || (((!Character.isDigit(this.equation.charAt(k))) && (this.equation.charAt(k) != '.')) || ((this.equation.charAt(k + 1) == '(') || ((this.equation.charAt(k) == ')') && (Character.isDigit(this.equation.charAt(k + 1))))))))
      {
        this.equation.insert(k + 1, 'x');
        k = 0;
      }
      k++;
      break label3943;
      label4596: if ((this.equation.charAt(m) == '-') && (m != -1 + this.equation.length()))
        this.equation.replace(m, m + 1, "-");
      m++;
      break label3958;
      label4648: if ((this.equation.toString().equals("Error!")) || (this.equation.indexOf("E") == -1) || (Math.abs(Double.parseDouble(this.equation.substring(1 + this.equation.indexOf("E"), this.equation.length()))) > 8.0D))
        continue;
      BigDecimal localBigDecimal1 = new BigDecimal(this.equation.substring(1 + this.equation.indexOf("E"), this.equation.length()));
      BigDecimal localBigDecimal2 = new BigDecimal(this.equation.substring(0, this.equation.indexOf("E")));
      this.equation.replace(0, this.equation.length(), localBigDecimal2.scaleByPowerOfTen(localBigDecimal1.intValue()).stripTrailingZeros().toPlainString());
    }
  }

	public void landscapeConfiguration() {
		this.textField = ((EditText) findViewById(2131034112));
		this.textField.setSelection(this.textField.getText().length());
		this.textField.setInputType(0);
		this.textField.setText(this.equation);
		this.buttonClear = ((Button) findViewById(2131034113));
		this.buttonDelete = ((Button) findViewById(2131034119));
		this.buttonAnswer = ((Button) findViewById(2131034125));
		this.buttonMultiply = ((Button) findViewById(2131034132));
		this.buttonBracketOpen = ((Button) findViewById(2131034114));
		this.buttonBracketClose = ((Button) findViewById(2131034120));
		this.buttonDivide = ((Button) findViewById(2131034131));
		this.button7 = ((Button) findViewById(2131034115));
		this.button8 = ((Button) findViewById(2131034121));
		this.button9 = ((Button) findViewById(2131034127));
		this.buttonSubtract = ((Button) findViewById(2131034133));
		this.button4 = ((Button) findViewById(2131034116));
		this.button5 = ((Button) findViewById(2131034122));
		this.button6 = ((Button) findViewById(2131034128));
		this.buttonAdd = ((Button) findViewById(2131034134));
		this.button1 = ((Button) findViewById(2131034117));
		this.button2 = ((Button) findViewById(2131034123));
		this.button3 = ((Button) findViewById(2131034129));
		this.buttonEqual = ((Button) findViewById(2131034135));
		this.button0 = ((Button) findViewById(2131034118));
		this.buttonDecimal = ((Button) findViewById(2131034124));
		this.buttonNegative = ((Button) findViewById(2131034130));
		this.buttonInverse = ((Button) findViewById(2131034146));
		this.buttonLnInverse = ((Button) findViewById(2131034149));
		this.buttonLogInverse = ((Button) findViewById(2131034147));
		this.buttonFactorial = ((Button) findViewById(2131034142));
		this.buttonLog = ((Button) findViewById(2131034148));
		this.buttonLn = ((Button) findViewById(2131034150));
		this.buttonSin = ((Button) findViewById(2131034138));
		this.buttonCos = ((Button) findViewById(2131034141));
		this.buttonTan = ((Button) findViewById(2131034144));
		this.buttonSinInverse = ((Button) findViewById(2131034137));
		this.buttonCosInverse = ((Button) findViewById(2131034140));
		this.buttonTanInverse = ((Button) findViewById(2131034143));
		this.buttonPI = ((Button) findViewById(2131034136));
		this.buttonSquared = ((Button) findViewById(2131034152));
		this.buttonSquareRoot = ((Button) findViewById(2131034151));
		this.buttonExponent = ((Button) findViewById(2131034126));
		this.buttonDR = ((Button) findViewById(2131034145));
		this.buttonE = ((Button) findViewById(2131034139));
		this.buttonSquareRoot.setText(this.squareRoot);
		this.buttonSquared.setText(this.squaredText);
		this.buttonTanInverse.setText(this.tanInverseText);
		this.buttonCosInverse.setText(this.cosInverseText);
		this.buttonSinInverse.setText(this.sinInverseText);
		this.buttonDivide.setText(this.divide);
		this.buttonSubtract.setText(this.subtract);
		this.buttonNegative.setText(this.negative);
		this.buttonPI.setText(this.piSymbol);
		this.buttonLogInverse.setText(this.logInverseText);
		this.buttonLnInverse.setText(this.lnInverseText);
		this.buttonExponent.setText(this.exponentText);
		this.buttonInverse.setText(this.inverseText);
		this.button0.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("0");
			}
		});
		this.button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("1");
			}
		});
		this.button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("2");
			}
		});
		this.button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("3");
			}
		});
		this.button4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("4");
			}
		});
		this.button5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("5");
			}
		});
		this.button6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("6");
			}
		});
		this.button7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("7");
			}
		});
		this.button8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("8");
			}
		});
		this.button9.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("9");
			}
		});
		this.buttonDecimal.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(".");
			}
		});
		this.buttonEqual.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("=");
			}
		});
		this.buttonAdd.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("+");
			}
		});
		this.buttonSubtract.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(subtract);
			}
		});
		this.buttonMultiply.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("x");
			}
		});
		this.buttonDivide.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(divide);
			}
		});
		this.buttonBracketOpen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("(");
			}
		});
		this.buttonBracketClose.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(")");
			}
		});
		this.buttonLog.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("Log");
			}
		});
		this.buttonLn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("Ln");
			}
		});
		this.buttonSin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("Sin");
			}
		});
		this.buttonCos.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("Cos");
			}
		});
		this.buttonTan.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("Tan");
			}
		});
		this.buttonDelete.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("DEL");
			}
		});
		this.buttonInverse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("1/x");
			}
		});
		this.buttonSquareRoot.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(squareRoot);
			}
		});
		this.buttonSquared.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(squared);
			}
		});
		this.buttonPI.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(piSymbol);
			}
		});
		this.buttonClear.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("CE");
			}
		});
		this.buttonLogInverse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(logInverse);
			}
		});
		this.buttonLnInverse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(lnInverse);
			}
		});
		this.buttonSinInverse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(sinInverse);
			}
		});
		this.buttonCosInverse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(cosInverse);
			}
		});
		this.buttonTanInverse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(tanInverse);
			}
		});
		this.buttonExponent.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("^");
			}
		});
		this.buttonNegative.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(negative);
			}
		});
		this.buttonDR.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(buttonDR.getText().toString());
			}
		});
		this.buttonE.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("e");
			}
		});
		this.buttonAnswer.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("ANS");
			}
		});
		this.buttonFactorial.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("n!");
			}
		});
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		if (paramBundle != null)
			onRestoreInstanceState(paramBundle);
		if (getResources().getConfiguration().orientation == 1) {
			setContentView(2130903040);
			portraitConfiguration();
		}
		do
			return;
		while (getResources().getConfiguration().orientation != 2);
		setContentView(2130903040);
		landscapeConfiguration();
	}

	public void onDestroy() {
		super.onDestroy();
	}

	public void onPause() {
		super.onPause();
	}

	public void onRestoreInstanceState(Bundle paramBundle) {
		super.onRestoreInstanceState(paramBundle);
		this.equation.replace(0, this.equation.length(),
				paramBundle.getString("equation"));
		this.ans = paramBundle.getString("answer");
		this.lastChar = paramBundle.getChar("lastChar");
		this.numberOfOpenBrackets = paramBundle.getInt("numberOfOpenBrackets");
		this.numberOfClosedBrackets = paramBundle
				.getInt("numberOfClosedBrackets");
		this.equalPressed = paramBundle.getBoolean("equalPressed");
		this.decimalPressed = paramBundle.getBoolean("decimalPressed");
		this.allNumbersForNegSign = paramBundle
				.getBoolean("allNumbersForNegSign");
		this.negativePressed = paramBundle.getBoolean("negativePressed");
		this.rad = paramBundle.getBoolean("rad");
		this.deg = paramBundle.getBoolean("deg");
	}

	public void onResume() {
		super.onResume();
		if (getResources().getConfiguration().orientation == 1) {
			setContentView(2130903040);
			portraitConfiguration();
		}
		do
			return;
		while (getResources().getConfiguration().orientation != 2);
		setContentView(2130903040);
		landscapeConfiguration();
	}

	public void onSaveInstanceState(Bundle paramBundle) {
		super.onSaveInstanceState(paramBundle);
		paramBundle.putString("equation", this.equation.toString());
		paramBundle.putString("answer", this.ans);
		paramBundle.putChar("lastChar", this.lastChar);
		paramBundle.putInt("numberOfOpenBrackets", this.numberOfOpenBrackets);
		paramBundle.putInt("numberOfClosedBrackets",
				this.numberOfClosedBrackets);
		paramBundle.putBoolean("equalPressed", this.equalPressed);
		paramBundle.putBoolean("decimalPressed", this.decimalPressed);
		paramBundle.putBoolean("allNumbersForNegSign",
				this.allNumbersForNegSign);
		paramBundle.putBoolean("negativePressed", this.negativePressed);
		paramBundle.putBoolean("rad", this.rad);
		paramBundle.putBoolean("deg", this.deg);
	}

	public void portraitConfiguration() {
		this.textField = ((EditText) findViewById(2131034112));
		this.textField.setSelection(textField.getText().length());
		this.textField.setInputType(0);
		this.textField.setText(this.equation);
		this.buttonClear = ((Button) findViewById(2131034113));
		this.buttonDelete = ((Button) findViewById(2131034119));
		this.buttonAnswer = ((Button) findViewById(2131034125));
		this.buttonMultiply = ((Button) findViewById(2131034132));
		this.buttonBracketOpen = ((Button) findViewById(2131034114));
		this.buttonBracketClose = ((Button) findViewById(2131034120));
		this.buttonExponent = ((Button) findViewById(2131034126));
		this.buttonDivide = ((Button) findViewById(2131034131));
		this.button7 = ((Button) findViewById(2131034115));
		this.button8 = ((Button) findViewById(2131034121));
		this.button9 = ((Button) findViewById(2131034127));
		this.buttonSubtract = ((Button) findViewById(2131034133));
		this.button4 = ((Button) findViewById(2131034116));
		this.button5 = ((Button) findViewById(2131034122));
		this.button6 = ((Button) findViewById(2131034128));
		this.buttonAdd = ((Button) findViewById(2131034134));
		this.button1 = ((Button) findViewById(2131034117));
		this.button2 = ((Button) findViewById(2131034123));
		this.button3 = ((Button) findViewById(2131034129));
		this.buttonEqual = ((Button) findViewById(2131034135));
		this.button0 = ((Button) findViewById(2131034118));
		this.buttonDecimal = ((Button) findViewById(2131034124));
		this.buttonNegative = ((Button) findViewById(2131034130));
		this.buttonDivide.setText(this.divide);
		this.buttonSubtract.setText(this.subtract);
		this.buttonNegative.setText(this.negative);
		this.buttonExponent.setText(this.exponentText);
		this.button0.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("0");
			}
		});
		this.button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("1");
			}
		});
		this.button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("2");
			}
		});
		this.button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("3");
			}
		});
		this.button4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("4");
			}
		});
		this.button5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("5");
			}
		});
		this.button6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("6");
			}
		});
		this.button7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("7");
			}
		});
		this.button8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("8");
			}
		});
		this.button9.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("9");
			}
		});
		this.buttonDecimal.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(".");
			}
		});
		this.buttonEqual.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("=");
			}
		});
		this.buttonAdd.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("+");
			}
		});
		this.buttonSubtract.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(subtract);
			}
		});
		this.buttonMultiply.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("x");
			}
		});
		this.buttonDivide.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(divide);
			}
		});
		this.buttonBracketOpen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("(");
			}
		});
		this.buttonBracketClose.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(")");
			}
		});
		this.buttonExponent.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("^");
			}
		});
		this.buttonClear.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("CE");
			}
		});
		this.buttonDelete.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("DEL");
			}
		});
		this.buttonAnswer.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler("ANS");
			}
		});
		this.buttonNegative.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				ButtonHandler(negative);
			}
		});
	}
}