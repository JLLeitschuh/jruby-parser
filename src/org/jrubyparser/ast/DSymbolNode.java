/*
 ***** BEGIN LICENSE BLOCK *****
 * Version: CPL 1.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Common Public
 * License Version 1.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.eclipse.org/legal/cpl-v10.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 * Copyright (C) 2009 Thomas E. Enebo <tom.enebo@gmail.com>
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either of the GNU General Public License Version 2 or later (the "GPL"),
 * or the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the CPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the CPL, the GPL or the LGPL.
 ***** END LICENSE BLOCK *****/
package org.jrubyparser.ast;

import org.jrubyparser.NodeVisitor;
import org.jrubyparser.SourcePosition;

/**
 * Node representing symbol in a form like ':"3jane"'.
 */
public class DSymbolNode extends ListNode {
    /**
     * For mutating from a DStr to a DSym (we just create a new one with same contents).
     *
     * @param position the position
     * @param node to be copied
     */
    public DSymbolNode(SourcePosition position, DStrNode node) {
        super(position);

        assert node != null : "node is not null";

        addAll(node);
    }

    public DSymbolNode(SourcePosition position) {
        super(position);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.DSYMBOLNODE;
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitDSymbolNode(this);
    }

}
