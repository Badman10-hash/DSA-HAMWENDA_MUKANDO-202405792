# Pseudo-code for Infix to Postfix and Prefix Conversion

## 1. Infix to Postfix Conversion

```
Function infixToPostfix(expression):
  Create an empty stack `operatorStack`
  Create an empty string `postfixExpression`

  For each character `c` in `expression`:
    If `c` is an operand (letter or digit):
      Append `c` to `postfixExpression`
    Else if `c` is '(': 
      Push `c` onto `operatorStack`
    Else if `c` is ')':
      While `operatorStack` is not empty AND `operatorStack.peek()` is not '(': 
        Append `operatorStack.pop()` to `postfixExpression`
      If `operatorStack` is not empty AND `operatorStack.peek()` is '(': 
        Pop `operatorStack` (discard '(')
      Else:
        Return "Invalid Expression" (unmatched parenthesis)
    Else if `c` is an operator:
      While `operatorStack` is not empty AND `precedence(c)` <= `precedence(operatorStack.peek())`:
        If `operatorStack.peek()` is '(': 
          Return "Invalid Expression"
        Append `operatorStack.pop()` to `postfixExpression`
      Push `c` onto `operatorStack`

  While `operatorStack` is not empty:
    If `operatorStack.peek()` is '(': 
      Return "Invalid Expression" (unmatched parenthesis)
    Append `operatorStack.pop()` to `postfixExpression`

  Return `postfixExpression`
```

### Precedence Function

```
Function precedence(operator):
  If operator is '+' or '-':
    Return 1
  If operator is '*' or '/':
    Return 2
  If operator is '^':
    Return 3
  Return -1 (for non-operators or invalid operators)
```

## 2. Infix to Prefix Conversion

```
Function infixToPrefix(expression):
  Reverse the `expression`
  Replace all '(' with ')' and ')' with '(' in the reversed expression
  Let this be `modifiedExpression`

  Convert `modifiedExpression` to postfix using `infixToPostfix(modifiedExpression)`
  Let this be `postfixOfModified`

  Reverse `postfixOfModified`
  Return the reversed `postfixOfModified`
```
