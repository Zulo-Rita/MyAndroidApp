import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lecture_2.data.entities.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(user: Users): Long

    @Query("SELECT * FROM users_table WHERE id = :id LIMIT 1")
    suspend fun getById(id: Int): Users?

    @Query("SELECT * FROM users_table WHERE nickname = :nickname LIMIT 1")
    suspend fun getByEmail(nickname: String): Users?

    @Query("SELECT * FROM users_table ORDER BY full_name ASC")
    fun getAll(): Flow<List<Users>>

    @Query("DELETE FROM users_table WHERE id = :id")
    suspend fun deleteById(id: Int)

}

