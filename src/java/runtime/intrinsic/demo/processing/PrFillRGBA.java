/**
 * ADOBE SYSTEMS INCORPORATED
 * Copyright 2009-2013 Adobe Systems Incorporated
 * All Rights Reserved.
 *
 * NOTICE: Adobe permits you to use, modify, and distribute
 * this file in accordance with the terms of the MIT license,
 * a copy of which can be found in the LICENSE.txt file or at
 * http://opensource.org/licenses/MIT.
 */
package runtime.intrinsic.demo.processing;

import compile.type.Type;
import compile.type.Types;
import runtime.rep.lambda.IntrinsicLambda;
import runtime.rep.Tuple;

/**
 * Demo support, Processing hook
 *
 * @author Basil Hosmer
 */
public final class PrFillRGBA extends IntrinsicLambda
{
    public static final String NAME = "prfillrgba";

    public static final Type TYPE = Types.fun(
        Types.tup(Types.INT, Types.INT, Types.INT, Types.INT),
        Types.unit());

    public String getName()
    {
        return NAME;
    }

    public Type getType()
    {
        return TYPE;
    }

    public Object apply(final Object arg)
    {
        final Tuple args = (Tuple)arg;
        return invoke((Integer)args.get(0), (Integer)args.get(1), (Integer)args.get(2),
            (Integer)args.get(3));
    }

    /**
     * CAUTION not thread safe when called outside of setup/draw func
     */
    public static Tuple invoke(final int r, final int g, final int b,
        final int a)
    {
        if (Processing.INSTANCE != null)
        {
            Processing.INSTANCE.fill(r, g, b, a);
        }

        return Tuple.UNIT;
    }
}