package me.waynee95.postfix.lex;

%%

%public
%class Lexer
%function nextToken
%type Token

IntLiteral  = -? (0 | [1-9][0-9]*)
WhiteSpace  = (\r|\n|\r\n) | [ \t\f]

%states 

%%

{WhiteSpace}    { /* ignore */ }

"postfix"       { return new Token("postfix", null); }

{IntLiteral}    { return new Token("int", yytext()); }

"("             { return new Token("(", null); }
")"             { return new Token(")", null); }

"add"           { return new Token("add", null); }
"div"           { return new Token("div", null); }
"eq"            { return new Token("eq", null); }
"gt"            { return new Token("gt", null); }
"lt"            { return new Token("lt", null); }
"mul"           { return new Token("mul", null); }
"nget"          { return new Token("nget", null); }
"pop"           { return new Token("pop", null); }
"rem"           { return new Token("rem", null); }
"sel"           { return new Token("sel", null); }
"sub"           { return new Token("sub", null); }
"swap"          { return new Token("swap", null); }

// TODO: "exec"          { return new Token("exec", null); }

. { System.out.println("Unexpected character: " + yytext()); }