/* codigo de usuario */
package FrontEnd;
import java_cup.runtime.*;
import static Parsers.symUsers.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%class LexUsers
%cup
%cupdebug
%line
%column

numero = [0-9]*
hexa= [#][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]]
separadores = [ |\n|\r|\t]
comentario = [#][^]*
letras = [:jletterdigit:]+
errores = [^]
dospuntos = [":"]



%{

	private Symbol symbol(int type){
		return new Symbol(type, yyline+1, yycolumn+1);
	}
	private Symbol symbol(int type, Object value){
		return new Symbol(type, yyline+1, yycolumn+1,value);
	}


%}
%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {
	":" {return symbol(DOSPUNTOS);}
	";" {return symbol(PUNTOYCOMA;}
	"," {return symbol(COMA);}
	{numero} {return symbol(NUMERO,yytext());}
	{letras} {return symbol(ID,yytext());}
	

	
	{separadores}   	{}
	[errores] {}
}

