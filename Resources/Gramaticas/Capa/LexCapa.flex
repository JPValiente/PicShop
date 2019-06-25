/* codigo de usuario */
package Parsers;
import java_cup.runtime.*;
import static Parser.symCapas.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%class LexCapas
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
	("{") ({numero})(",")({numero})(",")({hexa}) ("}") {return symbol(CAPA);}
	(("I")|("i"))(("D")|("d"))) {return symbol(ID);}
	"{" {return symbol(LLAVEABIERTA);}
	"}" {return symbol(LLAVECERRADA);}
	{numero} {return symbol(NUMERO,yytext());}
	{hexa} {return symbol(HEXA,yytext());}
	";" {return symbol(PUNTOYCOMA);}
	"," {return symbol(COMA);}

	{separadores}   	{}
	[errores] {}
}

