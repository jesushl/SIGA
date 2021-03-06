/*
 
   Derby - Class org.apache.derbyTesting.functionTests.tests.jdbcapi.Wrapper41Statement
 
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to you under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 
 */

package org.apache.derbyTesting.functionTests.tests.jdbcapi;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.apache.derby.iapi.jdbc.EngineStatement;
import org.apache.derby.client.am.LogicalPreparedStatement;

/**
 * A wrapper around the new Statement methods added by JDBC 4.1.
 */
public  class   Wrapper41Statement
{
    ///////////////////////////////////////////////////////////////////////
    //
    // STATE
    //
    ///////////////////////////////////////////////////////////////////////

    private EngineStatement     _engineStatement;
    private org.apache.derby.client.am.Statement       _netStatement;
    private LogicalPreparedStatement  _logicalStatement;
    
    ///////////////////////////////////////////////////////////////////////
    //
    // CONSTRUCTORS
    //
    ///////////////////////////////////////////////////////////////////////

    public Wrapper41Statement( Object wrapped ) throws Exception
    {
        if ( wrapped instanceof EngineStatement ) { _engineStatement = (EngineStatement) wrapped; }
        else if ( wrapped instanceof org.apache.derby.client.am.Statement ) { _netStatement = (org.apache.derby.client.am.Statement) wrapped; }
        else if ( wrapped instanceof LogicalPreparedStatement ) { _logicalStatement = (LogicalPreparedStatement) wrapped; }
        else { throw nothingWrapped(); }
    }
    
    ///////////////////////////////////////////////////////////////////////
    //
    // JDBC 4.1 BEHAVIOR
    //
    ///////////////////////////////////////////////////////////////////////

    public  void    closeOnCompletion() throws SQLException
    {
        if ( _engineStatement != null ) { _engineStatement.closeOnCompletion(); }
        else if ( _netStatement != null ) { _netStatement.closeOnCompletion(); }
        else if ( _logicalStatement != null ) { _logicalStatement.closeOnCompletion(); }
        else { throw nothingWrapped(); }
    }

    public  boolean isCloseOnCompletion() throws SQLException
    {
        if ( _engineStatement != null ) { return _engineStatement.isCloseOnCompletion(); }
        else if ( _netStatement != null ) { return _netStatement.isCloseOnCompletion(); }
        else if ( _logicalStatement != null ) { return _logicalStatement.isCloseOnCompletion(); }
        else { throw nothingWrapped(); }
    }


    ///////////////////////////////////////////////////////////////////////
    //
    // OTHER PUBLIC BEHAVIOR
    //
    ///////////////////////////////////////////////////////////////////////

    public java.sql.Statement   getWrappedObject() throws SQLException
    {
        if ( _engineStatement != null ) { return _engineStatement; }
        else if ( _netStatement != null ) { return _netStatement; }
        else if ( _logicalStatement != null ) { return _logicalStatement; }
        else { throw nothingWrapped(); }
    }

    public  boolean isClosed()  throws Exception
    {
        java.sql.Statement  stmt = getWrappedObject();
        Method  method = stmt.getClass().getMethod( "isClosed", null );

        return ((Boolean) method.invoke( stmt, null )).booleanValue();
    }

    ///////////////////////////////////////////////////////////////////////
    //
    // MINIONS
    //
    ///////////////////////////////////////////////////////////////////////

    private SQLException nothingWrapped() { return new SQLException( "Nothing wrapped!" ); }

}

