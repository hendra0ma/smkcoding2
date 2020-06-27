package com.corona.savelive.DAO;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.corona.savelive.model.Modelinsert;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PesanDAO_Impl implements PesanDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Modelinsert> __insertionAdapterOfModelinsert;

  private final EntityDeletionOrUpdateAdapter<Modelinsert> __deletionAdapterOfModelinsert;

  private final EntityDeletionOrUpdateAdapter<Modelinsert> __updateAdapterOfModelinsert;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public PesanDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModelinsert = new EntityInsertionAdapter<Modelinsert>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Pesan` (`id`,`nama`,`pesan`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modelinsert value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getNama() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama());
        }
        if (value.getPesan() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPesan());
        }
      }
    };
    this.__deletionAdapterOfModelinsert = new EntityDeletionOrUpdateAdapter<Modelinsert>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Pesan` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modelinsert value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfModelinsert = new EntityDeletionOrUpdateAdapter<Modelinsert>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `Pesan` SET `id` = ?,`nama` = ?,`pesan` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Modelinsert value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getNama() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama());
        }
        if (value.getPesan() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPesan());
        }
        if (value.getId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Pesan";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Modelinsert myFriend, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfModelinsert.insert(myFriend);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object insertAll(final List<Modelinsert> myFriends, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfModelinsert.insert(myFriends);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final Modelinsert myFriend, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfModelinsert.handle(myFriend);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object update(final Modelinsert myFriend, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfModelinsert.handle(myFriend);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public LiveData<List<Modelinsert>> getAllPesan() {
    final String _sql = "Select * from Pesan";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Pesan"}, false, new Callable<List<Modelinsert>>() {
      @Override
      public List<Modelinsert> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
          final int _cursorIndexOfPesan = CursorUtil.getColumnIndexOrThrow(_cursor, "pesan");
          final List<Modelinsert> _result = new ArrayList<Modelinsert>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Modelinsert _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpNama;
            _tmpNama = _cursor.getString(_cursorIndexOfNama);
            final String _tmpPesan;
            _tmpPesan = _cursor.getString(_cursorIndexOfPesan);
            _item = new Modelinsert(_tmpId,_tmpNama,_tmpPesan);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
