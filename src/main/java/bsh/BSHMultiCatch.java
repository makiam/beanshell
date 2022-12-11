/* Generated by: JJTree: Do not edit this line. BSHMultiCatch.java Version 1.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=BSH,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
/** Copyright 2018 Nick nickl- Lombard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */
package bsh;

public class BSHMultiCatch extends SimpleNode {
    private static final long serialVersionUID = 1L;
    public static final Class<?> UNTYPED = null;
    public String name;
    public boolean isFinal = false;
    public Class<?>[] types;
    public BSHMultiCatch(int id) { super(id); }

    public int countTypes() {
        if ( jjtGetNumChildren() > 0 )
            return jjtGetNumChildren();
        return 1;
    }

    public boolean isFinal() {
        if ( isFinal )
            return true;
        return countTypes() > 1;
    }

    public boolean isUntyped() {
        return 0 == jjtGetNumChildren();
    }

    /**
        Evaluate the types.
     */
    public Object eval( CallStack callstack, Interpreter interpreter) throws EvalError {
        if ( null != types )
            return types;

        types = new Class[countTypes()];
        if ( isUntyped() )
            types[0] = UNTYPED;
        else for ( int i=0; i< countTypes(); i++ )
            types[i] = ((BSHType) jjtGetChild(i)).getType( callstack, interpreter );

        return types;
    }

    public Class<?>[] getTypes() {
        return this.types;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + name + ", final=" + isFinal;
    }
}
/* JavaCC - OriginalChecksum=cc337eefa5f343b6ba168cc49758c10a (do not edit this line) */
