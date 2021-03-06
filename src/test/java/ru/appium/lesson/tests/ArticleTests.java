package ru.appium.lesson.tests;

import org.junit.Test;

import ru.appium.lesson.lib.CoreTestCase;
import ru.appium.lesson.lib.ui.ArticlePageObject;
import ru.appium.lesson.lib.ui.SearchPageObject;
import ru.appium.lesson.lib.ui.WelcomePageObject;
import ru.appium.lesson.lib.ui.factories.ArticlePageObjectFactory;
import ru.appium.lesson.lib.ui.factories.SearchPageObjectFactory;
import ru.appium.lesson.lib.ui.factories.WelcomePageObjectFactory;

public class ArticleTests extends CoreTestCase {

  private WelcomePageObject welcome;
  private SearchPageObject search;
  private ArticlePageObject article;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.welcome = WelcomePageObjectFactory.get(this.driver);
    this.search = SearchPageObjectFactory.get(this.driver);
    this.article = ArticlePageObjectFactory.get(this.driver);
  }

  @Test
  public void testCompareArticleTitle() {
    String searchText = "Java";
    String articleTitle = "Object-oriented programming language";
    this.welcome.skipWelcome();
    this.search.initSearchInput();
    this.search.typeSearchLine(searchText);
    this.search.clickByArticleWithSubstring(articleTitle);
    String title = this.article.getArticleTitle();
    assertEquals("We see unexpected title", "Java (programming language)", title);
  }

  @Test
  public void testSwipeArticle() {
    String searchText = "Java";
    String articleTitle = "Object-oriented programming language";
    this.welcome.skipWelcome();
    this.search.initSearchInput();
    this.search.typeSearchLine(searchText);
    this.search.clickByArticleWithSubstring(articleTitle);
    this.article.waitForTitleElement();
    this.article.swipeToFooter();
  }
}
