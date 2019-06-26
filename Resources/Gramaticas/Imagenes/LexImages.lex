/* codigo de usuario */
package Parsers;
import java_cup.runtime.*;
import static Parsers.symImage.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%class LexImages
%cup
%cupdebug
%line
%column

numero = [0-9]*
hexa= [#][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]][[A-F]|[0-9]]
separadores = [ |\n|\r|\t]
comentario = [#][^]*
letras = [:jletterdigit:]*
errores = [^]



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
	{numero} {return symbol(NUMERO,yytext());}
	"{" {return symbol(LLAVEABIERTA,yytext());}
	"}" {return symbol(LLAVECERRADA,yytext());}
	"," {return symbol(COMA);}

	{separadores}   	{}
	[errores] {}
}

